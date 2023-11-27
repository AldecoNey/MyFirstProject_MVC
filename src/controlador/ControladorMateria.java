package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControladorMateria implements ActionListener, MouseListener, ItemListener {

    private vista.VistaMateria materiaVista;
    private modelo.ModeloMateria materiaModelo;
    private DefaultTableModel modeloTabla;

    public vista.VistaMateria getMateriaVista() {
        return materiaVista;
    }

    public ControladorMateria(vista.VistaMateria vista, modelo.ModeloMateria modelo) {
        this.materiaVista = vista;
        this.materiaModelo = modelo;
        this.materiaVista.setVisible(true);
        llenarFilas(this.materiaVista.getTableMateria());
        escucharBotones();
        this.materiaVista.getJtCodMat().setEditable(false);
        agregarEventoMouse(this.materiaVista.getJBVolver());
        agregarEventoMouse(this.materiaVista.getJBModificar());
        agregarEventoMouse(this.materiaVista.getJBEliminar());
        agregarEventoMouse(this.materiaVista.getJBAgregar());
        agregarEventoMouseBorrarTexto(this.materiaVista.getJtNombreMat());
    }

    public void escucharBotones() {
        this.materiaVista.getJBVolver().addActionListener(this);
        this.materiaVista.getJBAgregar().addActionListener(this);
        this.materiaVista.getTableMateria().addMouseListener(this);
        this.materiaVista.getJBEliminar().addActionListener(this);
        this.materiaVista.getJBModificar().addActionListener(this);
    }

    public void agregarEventoMouse(JButton boton) {
        boton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                boton.setBackground(new Color(255, 122, 122));
            }

            public void mouseExited(MouseEvent evento) {
                boton.setBackground(new Color(255, 153, 153));
            }
        });
    }

    public void agregarEventoMouseBorrarTexto(JTextField textField) {
        textField.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                textField.setText("");
                textField.setForeground(Color.BLACK);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource().equals(this.materiaVista.getJBAgregar())) {
            if (materiaModelo.validaCarga(this.materiaVista.getJtNombreMat().getText())) {
                JOptionPane.showMessageDialog(null, "Los campos nombre no pueden estar vacios");

            } else {
                this.materiaModelo.setNombre(this.materiaVista.getJtNombreMat().getText());
                if (this.materiaModelo.cargaDatos(materiaModelo)) {
                    JOptionPane.showMessageDialog(null, "Materia cargada correctamente");
                }
                this.limpiarTabla(this.materiaVista.getTableMateria());
                llenarFilas(this.materiaVista.getTableMateria());
                limpiaCuadros();

            }
        } else if (evento.getSource().equals(this.materiaVista.getJBVolver())) {
            vista.VistaMenuPrincipal menuVista = new vista.VistaMenuPrincipal();
            ControladorMenuPrincipal menuControlador = new ControladorMenuPrincipal(menuVista);
            this.materiaVista.dispose();

        } else if (evento.getSource().equals(this.materiaVista.getJBEliminar())) {
            if (this.materiaModelo.baja(this.materiaVista.getTableMateria())) {
                limpiarTabla(this.materiaVista.getTableMateria());
                llenarFilas(this.materiaVista.getTableMateria());
                JOptionPane.showMessageDialog(null, "Materia eliminada correctamente");
                limpiaCuadros();

            }

        } else if (evento.getSource().equals(this.materiaVista.getJBModificar())) {
            this.materiaModelo.setCodigo(Integer.parseInt(this.materiaVista.getJtCodMat().getText()));
            this.materiaModelo.setNombre(this.materiaVista.getJtNombreMat().getText());
            if (this.materiaModelo.modifica(materiaModelo)) {
                JOptionPane.showMessageDialog(null, "Materia modificada correctamente");
            }
            this.limpiarTabla(this.materiaVista.getTableMateria());
            llenarFilas(this.materiaVista.getTableMateria());
            limpiaCuadros();

        }

    }

    public String[] dameColumnas() {
        String[] Columna = {"Codigo", "Nombre"};
        return Columna;
    }

    public void limpiarTabla(JTable tabla) {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public void llenarFilas(JTable tabla) {
        modeloTabla = new DefaultTableModel(null, dameColumnas());
        ArrayList<modelo.ModeloMateria> materias;
        materias = this.materiaModelo.listarMaterias();
        this.limpiarTabla(this.materiaVista.getTableMateria());
        Object datos[] = new Object[2];
        if (materias.size() > 0) {
            for (int i = 0; i < materias.size(); i++) {
                datos[0] = materias.get(i).getCodigo();
                datos[1] = materias.get(i).getNombre();
                modeloTabla.addRow(datos);
            }
        }

        tabla.setModel(modeloTabla);
        materias.clear();

    }

    public void limpiaCuadros() {
        this.materiaVista.getJtNombreMat().setText("");
        this.materiaVista.getJtCodMat().setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            int fila = this.materiaVista.getTableMateria().rowAtPoint(e.getPoint());
            if (fila > -1) {
                this.materiaVista.getJtCodMat().setText(String.valueOf(this.materiaVista.getTableMateria().getValueAt(fila, 0)));
                this.materiaVista.getJtNombreMat().setText(String.valueOf(this.materiaVista.getTableMateria().getValueAt(fila, 1)));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
