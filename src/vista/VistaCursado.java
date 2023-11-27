/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author neyda
 */
public class VistaCursado extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();

    /**
     * Creates new form VistaCursado
     */
    public VistaCursado() {
        initComponents();
    }

    public JButton getJBAgregar() {
        return JBAgregar;
    }

    public void setJBAgregar(JButton JBAgregar) {
        this.JBAgregar = JBAgregar;
    }

    public JButton getJBEliminar() {
        return JBEliminar;
    }

    public void setJBEliminar(JButton JBEliminar) {
        this.JBEliminar = JBEliminar;
    }

    public JButton getJBModificar() {
        return JBModificar;
    }

    public void setJBModificar(JButton JBModificar) {
        this.JBModificar = JBModificar;
    }

    public JButton getJBVolver() {
        return JBVolver;
    }

    public void setJBVolver(JButton JBVolver) {
        this.JBVolver = JBVolver;
    }

    public JTable getjTableCurs() {
        return jTableCurs;
    }

    public void setjTableCurs(JTable jTableCurs) {
        this.jTableCurs = jTableCurs;
    }

    public JComboBox<String> getjCBCodigoMateria() {
        return jCBCodigoMateria;
    }

    public void setjCBCodigoMateria(JComboBox<String> jCBCodigoMateria) {
        this.jCBCodigoMateria = jCBCodigoMateria;
    }

    public JComboBox<String> getjCBDniAlumno() {
        return jCBDniAlumno;
    }

    public void setjCBDniAlumno(JComboBox<String> jCBDniAlumno) {
        this.jCBDniAlumno = jCBDniAlumno;
    }

    public JTextField getJtNota() {
        return jtNota;
    }

    public void setJtNota(JTextField jtNota) {
        this.jtNota = jtNota;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpVistaCur = new javax.swing.JPanel();
        jpTituloCur = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlDniAlu = new javax.swing.JLabel();
        jlCodMat = new javax.swing.JLabel();
        jlNota = new javax.swing.JLabel();
        jtNota = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCurs = new javax.swing.JTable();
        JBAgregar = new javax.swing.JButton();
        JBModificar = new javax.swing.JButton();
        JBEliminar = new javax.swing.JButton();
        JBVolver = new javax.swing.JButton();
        jCBCodigoMateria = new javax.swing.JComboBox<>();
        jCBDniAlumno = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpVistaCur.setBackground(new java.awt.Color(234, 255, 234));

        jpTituloCur.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CURSADO");

        javax.swing.GroupLayout jpTituloCurLayout = new javax.swing.GroupLayout(jpTituloCur);
        jpTituloCur.setLayout(jpTituloCurLayout);
        jpTituloCurLayout.setHorizontalGroup(
            jpTituloCurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpTituloCurLayout.setVerticalGroup(
            jpTituloCurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jlDniAlu.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jlDniAlu.setForeground(new java.awt.Color(0, 0, 0));
        jlDniAlu.setText("DNI de alumno");

        jlCodMat.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jlCodMat.setForeground(new java.awt.Color(0, 0, 0));
        jlCodMat.setText("Codigo de materia");

        jlNota.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jlNota.setForeground(new java.awt.Color(0, 0, 0));
        jlNota.setText("NOTA");

        jtNota.setBackground(new java.awt.Color(255, 255, 255));
        jtNota.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jtNota.setForeground(new java.awt.Color(153, 153, 153));
        jtNota.setText("Ingrese nota");
        jtNota.setBorder(null);

        jTableCurs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableCurs);

        JBAgregar.setBackground(new java.awt.Color(0, 153, 0));
        JBAgregar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        JBAgregar.setForeground(new java.awt.Color(255, 255, 255));
        JBAgregar.setText("Agregar");
        JBAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JBModificar.setBackground(new java.awt.Color(0, 153, 0));
        JBModificar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        JBModificar.setForeground(new java.awt.Color(255, 255, 255));
        JBModificar.setText("Modificar");
        JBModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JBEliminar.setBackground(new java.awt.Color(0, 153, 0));
        JBEliminar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        JBEliminar.setForeground(new java.awt.Color(255, 255, 255));
        JBEliminar.setText("Eliminar");
        JBEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JBVolver.setBackground(new java.awt.Color(0, 153, 0));
        JBVolver.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JBVolver.setForeground(new java.awt.Color(255, 255, 255));
        JBVolver.setText("Volver");
        JBVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jCBCodigoMateria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCBDniAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jpVistaCurLayout = new javax.swing.GroupLayout(jpVistaCur);
        jpVistaCur.setLayout(jpVistaCurLayout);
        jpVistaCurLayout.setHorizontalGroup(
            jpVistaCurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTituloCur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpVistaCurLayout.createSequentialGroup()
                .addGroup(jpVistaCurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVistaCurLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(JBAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156)
                        .addComponent(JBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(JBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpVistaCurLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jpVistaCurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpVistaCurLayout.createSequentialGroup()
                                .addComponent(jlDniAlu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBDniAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlCodMat, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBCodigoMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlNota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpVistaCurLayout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(JBVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jpVistaCurLayout.setVerticalGroup(
            jpVistaCurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVistaCurLayout.createSequentialGroup()
                .addComponent(jpTituloCur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jpVistaCurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDniAlu)
                    .addComponent(jlCodMat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBCodigoMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBDniAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jpVistaCurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(JBVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        getContentPane().add(jpVistaCur, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VistaCursado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCursado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCursado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCursado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCursado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAgregar;
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBModificar;
    private javax.swing.JButton JBVolver;
    private javax.swing.JComboBox<String> jCBCodigoMateria;
    private javax.swing.JComboBox<String> jCBDniAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCurs;
    private javax.swing.JLabel jlCodMat;
    private javax.swing.JLabel jlDniAlu;
    private javax.swing.JLabel jlNota;
    private javax.swing.JPanel jpTituloCur;
    private javax.swing.JPanel jpVistaCur;
    private javax.swing.JTextField jtNota;
    // End of variables declaration//GEN-END:variables
}