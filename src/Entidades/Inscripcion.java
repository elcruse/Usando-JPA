
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jimmy Coa
 */
@Entity
@Table(name = "inscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscripcion.findAll", query = "SELECT i FROM Inscripcion i")
    , @NamedQuery(name = "Inscripcion.findByIdinsc", query = "SELECT i FROM Inscripcion i WHERE i.idinsc = :idinsc")
    , @NamedQuery(name = "Inscripcion.findByNotaAlumno", query = "SELECT i FROM Inscripcion i WHERE i.notaAlumno = :notaAlumno")})
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinsc")
    private Integer idinsc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "notaAlumno")
    private Float notaAlumno;
    @JoinColumn(name = "alumno_dni", referencedColumnName = "dni")
    @ManyToOne(optional = false)
    private Alumno alumnoDni;
    @JoinColumn(name = "curso_idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
    private Curso cursoIdcurso;

    public Inscripcion() {
    }

    public Inscripcion(Integer idinsc) {
        this.idinsc = idinsc;
    }

    public Integer getIdinsc() {
        return idinsc;
    }

    public void setIdinsc(Integer idinsc) {
        this.idinsc = idinsc;
    }

    public Float getNotaAlumno() {
        return notaAlumno;
    }

    public void setNotaAlumno(Float notaAlumno) {
        this.notaAlumno = notaAlumno;
    }

    public Alumno getAlumnoDni() {
        return alumnoDni;
    }

    public void setAlumnoDni(Alumno alumnoDni) {
        this.alumnoDni = alumnoDni;
    }

    public Curso getCursoIdcurso() {
        return cursoIdcurso;
    }

    public void setCursoIdcurso(Curso cursoIdcurso) {
        this.cursoIdcurso = cursoIdcurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinsc != null ? idinsc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripcion)) {
            return false;
        }
        Inscripcion other = (Inscripcion) object;
        if ((this.idinsc == null && other.idinsc != null) || (this.idinsc != null && !this.idinsc.equals(other.idinsc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Inscripcion[ idinsc=" + idinsc + " ]";
    }
    
}
