/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JButton;

/**
 *
 * @author neyda
 */
public class VistaMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaMenuPrincipal
     */
    public VistaMenuPrincipal() {
        initComponents();
    }

    public JButton getJbAlumnos() {
        return jbAlumnos;
    }

    public void setJbAlumnos(JButton jbAlumnos) {
        this.jbAlumnos = jbAlumnos;
    }

    public JButton getJbCursados() {
        return jbCursados;
    }

    public void setJbCursados(JButton jbCursados) {
        this.jbCursados = jbCursados;
    }

    public JButton getJbMaterias() {
        return jbMaterias;
    }

    public void setJbMaterias(JButton jbMaterias) {
        this.jbMaterias = jbMaterias;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMenuP = new javax.swing.JPanel();
        jpTituloMP = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        jbAlumnos = new javax.swing.JButton();
        jbMaterias = new javax.swing.JButton();
        jbCursados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpMenuP.setBackground(new java.awt.Color(255, 255, 255));
        jpMenuP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpTituloMP.setBackground(new java.awt.Color(204, 204, 204));

        jlTitulo.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(0, 0, 0));
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("MENU PRINCIPAL");

        javax.swing.GroupLayout jpTituloMPLayout = new javax.swing.GroupLayout(jpTituloMP);
        jpTituloMP.setLayout(jpTituloMPLayout);
        jpTituloMPLayout.setHorizontalGroup(
            jpTituloMPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );
        jpTituloMPLayout.setVerticalGroup(
            jpTituloMPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jpMenuP.add(jpTituloMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jbAlumnos.setBackground(new java.awt.Color(0, 153, 153));
        jbAlumnos.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jbAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        jbAlumnos.setText("ALUMNOS");
        jbAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpMenuP.add(jbAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 170, 40));

        jbMaterias.setBackground(new java.awt.Color(255, 153, 153));
        jbMaterias.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jbMaterias.setForeground(new java.awt.Color(255, 255, 255));
        jbMaterias.setText("MATERIAS");
        jbMaterias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpMenuP.add(jbMaterias, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 169, 40));

        jbCursados.setBackground(new java.awt.Color(0, 204, 51));
        jbCursados.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jbCursados.setForeground(new java.awt.Color(255, 255, 255));
        jbCursados.setText("CURSADOS");
        jbCursados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpMenuP.add(jbCursados, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 170, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMenuP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMenuP, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(VistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAlumnos;
    private javax.swing.JButton jbCursados;
    private javax.swing.JButton jbMaterias;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JPanel jpMenuP;
    private javax.swing.JPanel jpTituloMP;
    // End of variables declaration//GEN-END:variables
}
