/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JButton;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author neyda
 */
public class VistaMateria extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();

    public VistaMateria() {
        initComponents();
    }

    public JTable getTableMateria() {
        return TableMateria;
    }

    public void setTableMateria(JTable TableMateria) {
        this.TableMateria = TableMateria;
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

    public JTextField getJtCodMat() {
        return jtCodMat;
    }

    public void setJtCodMat(JTextField jtCodMat) {
        this.jtCodMat = jtCodMat;
    }

    public JTextField getJtNombreMat() {
        return jtNombreMat;
    }

    public void setJtNombreMat(JTextField jtNombreMat) {
        this.jtNombreMat = jtNombreMat;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelVistaMat = new javax.swing.JPanel();
        jpTitulo = new javax.swing.JPanel();
        jlTituloMateria = new javax.swing.JLabel();
        jlCodMat = new javax.swing.JLabel();
        jlNombreMat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableMateria = new javax.swing.JTable();
        jtCodMat = new javax.swing.JTextField();
        jtNombreMat = new javax.swing.JTextField();
        JBAgregar = new javax.swing.JButton();
        JBModificar = new javax.swing.JButton();
        JBEliminar = new javax.swing.JButton();
        JBVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanelVistaMat.setBackground(new java.awt.Color(255, 242, 242));
        jPanelVistaMat.setPreferredSize(new java.awt.Dimension(688, 586));
        jPanelVistaMat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpTitulo.setBackground(new java.awt.Color(255, 204, 204));
        jpTitulo.setForeground(new java.awt.Color(255, 204, 204));

        jlTituloMateria.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jlTituloMateria.setForeground(new java.awt.Color(0, 0, 0));
        jlTituloMateria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTituloMateria.setText("MATERIA");

        javax.swing.GroupLayout jpTituloLayout = new javax.swing.GroupLayout(jpTitulo);
        jpTitulo.setLayout(jpTituloLayout);
        jpTituloLayout.setHorizontalGroup(
            jpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTituloMateria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpTituloLayout.setVerticalGroup(
            jpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTituloMateria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
        );

        jPanelVistaMat.add(jpTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 688, -1));

        jlCodMat.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jlCodMat.setForeground(new java.awt.Color(0, 0, 0));
        jlCodMat.setText("Codigo de materia");
        jPanelVistaMat.add(jlCodMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 129, 160, 25));

        jlNombreMat.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jlNombreMat.setForeground(new java.awt.Color(0, 0, 0));
        jlNombreMat.setText("Nombre");
        jPanelVistaMat.add(jlNombreMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        TableMateria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableMateria);

        jPanelVistaMat.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 245, 144));

        jtCodMat.setBackground(new java.awt.Color(255, 255, 255));
        jtCodMat.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jtCodMat.setForeground(new java.awt.Color(153, 153, 153));
        jtCodMat.setText("Ingrese el codigo");
        jtCodMat.setBorder(null);
        jPanelVistaMat.add(jtCodMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 139, 26));

        jtNombreMat.setBackground(new java.awt.Color(255, 255, 255));
        jtNombreMat.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jtNombreMat.setForeground(new java.awt.Color(153, 153, 153));
        jtNombreMat.setText("Ingrese el nombre");
        jtNombreMat.setBorder(null);
        jPanelVistaMat.add(jtNombreMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 230, 25));

        JBAgregar.setBackground(new java.awt.Color(255, 153, 153));
        JBAgregar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        JBAgregar.setForeground(new java.awt.Color(255, 255, 255));
        JBAgregar.setText("Agregar");
        JBAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelVistaMat.add(JBAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 130, 42));

        JBModificar.setBackground(new java.awt.Color(255, 153, 153));
        JBModificar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        JBModificar.setForeground(new java.awt.Color(255, 255, 255));
        JBModificar.setText("Modificar");
        JBModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelVistaMat.add(JBModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 130, 42));

        JBEliminar.setBackground(new java.awt.Color(255, 153, 153));
        JBEliminar.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        JBEliminar.setForeground(new java.awt.Color(255, 255, 255));
        JBEliminar.setText("Eliminar");
        JBEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelVistaMat.add(JBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 131, 40));

        JBVolver.setBackground(new java.awt.Color(255, 153, 153));
        JBVolver.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        JBVolver.setForeground(new java.awt.Color(255, 255, 255));
        JBVolver.setText("Volver");
        JBVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelVistaMat.add(JBVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVistaMat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVistaMat, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(VistaMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMateria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAgregar;
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBModificar;
    private javax.swing.JButton JBVolver;
    private javax.swing.JTable TableMateria;
    private javax.swing.JPanel jPanelVistaMat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlCodMat;
    private javax.swing.JLabel jlNombreMat;
    private javax.swing.JLabel jlTituloMateria;
    private javax.swing.JPanel jpTitulo;
    private javax.swing.JTextField jtCodMat;
    private javax.swing.JTextField jtNombreMat;
    // End of variables declaration//GEN-END:variables
}
