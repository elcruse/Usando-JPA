/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Alumno;
import Entidades.Curso;
import Entidades.Inscripcion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jimmy Coa
 */
public class InscripcionJpaController implements Serializable {

    public InscripcionJpaController() {
        this.emf = Persistence.createEntityManagerFactory("InscripcionConJPAPU");//esto es lo unico que se modifica
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Inscripcion inscripcion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumno alumnoDni = inscripcion.getAlumnoDni();
            if (alumnoDni != null) {
                alumnoDni = em.getReference(alumnoDni.getClass(), alumnoDni.getDni());
                inscripcion.setAlumnoDni(alumnoDni);
            }
            Curso cursoIdcurso = inscripcion.getCursoIdcurso();
            if (cursoIdcurso != null) {
                cursoIdcurso = em.getReference(cursoIdcurso.getClass(), cursoIdcurso.getIdcurso());
                inscripcion.setCursoIdcurso(cursoIdcurso);
            }
            em.persist(inscripcion);
            if (alumnoDni != null) {
                alumnoDni.getInscripcionList().add(inscripcion);
                alumnoDni = em.merge(alumnoDni);
            }
            if (cursoIdcurso != null) {
                cursoIdcurso.getInscripcionList().add(inscripcion);
                cursoIdcurso = em.merge(cursoIdcurso);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Inscripcion inscripcion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inscripcion persistentInscripcion = em.find(Inscripcion.class, inscripcion.getIdinsc());
            Alumno alumnoDniOld = persistentInscripcion.getAlumnoDni();
            Alumno alumnoDniNew = inscripcion.getAlumnoDni();
            Curso cursoIdcursoOld = persistentInscripcion.getCursoIdcurso();
            Curso cursoIdcursoNew = inscripcion.getCursoIdcurso();
            if (alumnoDniNew != null) {
                alumnoDniNew = em.getReference(alumnoDniNew.getClass(), alumnoDniNew.getDni());
                inscripcion.setAlumnoDni(alumnoDniNew);
            }
            if (cursoIdcursoNew != null) {
                cursoIdcursoNew = em.getReference(cursoIdcursoNew.getClass(), cursoIdcursoNew.getIdcurso());
                inscripcion.setCursoIdcurso(cursoIdcursoNew);
            }
            inscripcion = em.merge(inscripcion);
            if (alumnoDniOld != null && !alumnoDniOld.equals(alumnoDniNew)) {
                alumnoDniOld.getInscripcionList().remove(inscripcion);
                alumnoDniOld = em.merge(alumnoDniOld);
            }
            if (alumnoDniNew != null && !alumnoDniNew.equals(alumnoDniOld)) {
                alumnoDniNew.getInscripcionList().add(inscripcion);
                alumnoDniNew = em.merge(alumnoDniNew);
            }
            if (cursoIdcursoOld != null && !cursoIdcursoOld.equals(cursoIdcursoNew)) {
                cursoIdcursoOld.getInscripcionList().remove(inscripcion);
                cursoIdcursoOld = em.merge(cursoIdcursoOld);
            }
            if (cursoIdcursoNew != null && !cursoIdcursoNew.equals(cursoIdcursoOld)) {
                cursoIdcursoNew.getInscripcionList().add(inscripcion);
                cursoIdcursoNew = em.merge(cursoIdcursoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = inscripcion.getIdinsc();
                if (findInscripcion(id) == null) {
                    throw new NonexistentEntityException("The inscripcion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inscripcion inscripcion;
            try {
                inscripcion = em.getReference(Inscripcion.class, id);
                inscripcion.getIdinsc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inscripcion with id " + id + " no longer exists.", enfe);
            }
            Alumno alumnoDni = inscripcion.getAlumnoDni();
            if (alumnoDni != null) {
                alumnoDni.getInscripcionList().remove(inscripcion);
                alumnoDni = em.merge(alumnoDni);
            }
            Curso cursoIdcurso = inscripcion.getCursoIdcurso();
            if (cursoIdcurso != null) {
                cursoIdcurso.getInscripcionList().remove(inscripcion);
                cursoIdcurso = em.merge(cursoIdcurso);
            }
            em.remove(inscripcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inscripcion> findInscripcionEntities() {
        return findInscripcionEntities(true, -1, -1);
    }

    public List<Inscripcion> findInscripcionEntities(int maxResults, int firstResult) {
        return findInscripcionEntities(false, maxResults, firstResult);
    }

    private List<Inscripcion> findInscripcionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Inscripcion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Inscripcion findInscripcion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Inscripcion.class, id);
        } finally {
            em.close();
        }
    }

    public int getInscripcionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Inscripcion> rt = cq.from(Inscripcion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
