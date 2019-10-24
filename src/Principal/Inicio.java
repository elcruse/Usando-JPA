
package Principal;

import Controladores.AlumnoJpaController;
import Controladores.CursoJpaController;
import Controladores.InscripcionJpaController;
import Entidades.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jimmy coa 
 */
public class Inicio extends javax.swing.JFrame {
    AlumnoJpaController alumnos=new AlumnoJpaController();
    CursoJpaController cursos=new CursoJpaController();
    InscripcionJpaController ins= new InscripcionJpaController();// aca se instancia el controlador
    //String lista;
    int idcur;
    
    public Inicio() {
        initComponents();
        CrearModelo();
        cargarInformacion();
        mostrarlista();
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Btnguardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textdni = new javax.swing.JTextField();
        textnombre = new javax.swing.JTextField();
        textape = new javax.swing.JTextField();
        textedad = new javax.swing.JTextField();
        textnotaA = new javax.swing.JTextField();
        boxcursos = new javax.swing.JComboBox<>();
        textlista = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Conexion Java+Mysql+JPA");

        Btnguardar.setText("Guardar");
        Btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnguardarActionPerformed(evt);
            }
        });

        jLabel2.setText("DNI:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellido:");

        jLabel5.setText("Edad:");

        jLabel6.setText("Id Curso:");

        jLabel7.setText("Nota Alumno:");

        textdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textdniActionPerformed(evt);
            }
        });

        textedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textedadActionPerformed(evt);
            }
        });

        boxcursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxcursosActionPerformed(evt);
            }
        });

        textlista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textlistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(51, 51, 51)
                                .addComponent(textnotaA, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(boxcursos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textape))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                                .addComponent(textedad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textdni)
                                            .addComponent(textnombre))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textlista)))
                        .addGap(18, 18, 18)
                        .addComponent(Btnguardar)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(boxcursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textlista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textnotaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btnguardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnguardarActionPerformed
        
        
        Alumno alu= new Alumno();//Boton guardar
        Curso curso=new Curso();
        Inscripcion in=new Inscripcion();
        alu.setDni(Integer.parseInt(textdni.getText()));
        alu.setNombre(textnombre.getText());
        alu.setApellido(textape.getText());
        alu.setEdad(Integer.parseInt(textedad.getText()));
        
        curso=cursos.findCurso(idcur+1);
        in.setNotaAlumno(Float.parseFloat(textnotaA.getText()));
        in.setCursoIdcurso(curso);
        
        
        
        
        try {
            
            alumnos.create(alu);
            alu=alumnos.getEntityManager().find(Alumno.class,Integer.parseInt(textdni.getText()));
            in.setAlumnoDni(alu);
            ins.create(in);
            
            
            //cursos.create(curso);
            JOptionPane.showMessageDialog(null, "Los Datos han sido Guardados con exito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        
        
    }//GEN-LAST:event_BtnguardarActionPerformed

    private void textdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textdniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textdniActionPerformed

    private void textedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textedadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textedadActionPerformed

    private void boxcursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxcursosActionPerformed
      
     
            List<Curso> c=cursos.findCursoEntities();
            String  lista=boxcursos.getSelectedItem().toString();
            idcur=(Integer.parseInt(lista));
            textlista.setText(Integer.toString(idcur));
            idcur=idcur-1;
            
            System.out.println("Esto es el idcurso y trae la clase: "+cursos.findCurso(idcur+1));
            System.out.println("Esto es el idDni y trae la clase: "+alumnos.findAlumno(11225544).getNombre());
            System.out.println("Muestra una lista ArrayList de los cursos: "+cursos.findCursoEntities().get(idcur).getNombrecur());
            System.out.println("Muestra cuantos objetos hay: "+cursos.getCursoCount());
            System.out.println("muuestra getEntityManager(): "+cursos.getEntityManager().find(Inscripcion.class, idcur+1).getAlumnoDni());
            System.out.println("muuestra getEntityManager(): "+alumnos.getEntityManager().find(Alumno.class,11225544).getNombre());
            //System.out.println(c.get(idcur).getCupo());
            
        

    }//GEN-LAST:event_boxcursosActionPerformed

    private void textlistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textlistaActionPerformed
            
            
    }//GEN-LAST:event_textlistaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
    
    DefaultTableModel modelo2;

    private void CrearModelo() {
        try {
            modelo2 = (new DefaultTableModel(
                    null, new String[]{
                        "id", "Nota",
                        "Curso", "Alumno"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class
                        
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            tabla.setModel(modelo2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }
    
    private void cargarInformacion(){
        try {
            Object o[]=null;
            List<Inscripcion> listaIns=ins.findInscripcionEntities();// aca se guarda el listado de nuestra base de datos
            
            for(int i=0;i<listaIns.size();i++){
                modelo2.addRow(o);// aca le pasamos un objeto vacio "o" que ya esta mas arriba declarado, para llenarlo
                modelo2.setValueAt(listaIns.get(i).getIdinsc(),i, 0);
                modelo2.setValueAt(listaIns.get(i).getNotaAlumno(),i, 1);
                modelo2.setValueAt(listaIns.get(i).getCursoIdcurso().getNombrecur(),i, 2);
                modelo2.setValueAt(listaIns.get(i).getAlumnoDni().getNombre(),i, 3);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void mostrarlista(){
        try {
         List<Curso> c;   
        c= cursos.findCursoEntities();
        
        for (int i = 0; i <c.size(); i++) {
            boxcursos.addItem(c.get(i).getIdcurso().toString());
            
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnguardar;
    private javax.swing.JComboBox<String> boxcursos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField textape;
    private javax.swing.JTextField textdni;
    private javax.swing.JTextField textedad;
    private javax.swing.JTextField textlista;
    private javax.swing.JTextField textnombre;
    private javax.swing.JTextField textnotaA;
    // End of variables declaration//GEN-END:variables
}
