package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ControladorAlumno implements ActionListener, MouseListener {

    private modelo.ModeloAlumno alumnoModelo;
    private vista.VistaAlumno alumnoVista;
    private DefaultTableModel modeloTabla;

    public ControladorAlumno(modelo.ModeloAlumno modelo, vista.VistaAlumno vista) throws SQLException {
        this.alumnoModelo = modelo;
        this.alumnoVista = vista;
        this.alumnoVista.setVisible(true);
        this.llenarFilas(this.alumnoVista.getjTableAlu());
        escucharBotones();
        agregarEventoMouse(this.alumnoVista.getBotonAgregar());
        agregarEventoMouse(this.alumnoVista.getBotonEliminar());
        agregarEventoMouse(this.alumnoVista.getBotonModificar());
        agregarEventoMouse(this.alumnoVista.getBotonVolver());
        agregarEventoMouseBorrarTexto(this.alumnoVista.getTfDNI());
        agregarEventoMouseBorrarTexto(this.alumnoVista.getTfApellido());
        agregarEventoMouseBorrarTexto(this.alumnoVista.getTfDomicilio());
        agregarEventoMouseBorrarTexto(this.alumnoVista.getTfTelefono());
        agregarEventoMouseBorrarTexto(this.alumnoVista.getTfNombre());
    }

    public void escucharBotones() {
        this.alumnoVista.getBotonAgregar().addActionListener(this);
        this.alumnoVista.getBotonVolver().addActionListener(this);
        this.alumnoVista.getBotonEliminar().addActionListener(this);
        this.alumnoVista.getjTableAlu().addMouseListener(this);
        this.alumnoVista.getBotonModificar().addActionListener(this);
    }

    public void agregarEventoMouse(JButton boton) {
        boton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                boton.setBackground(new Color(0, 122, 122));
            }

            public void mouseExited(MouseEvent evento) {
                boton.setBackground(new Color(0, 153, 153));
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

        if (evento.getSource().equals(this.alumnoVista.getBotonAgregar())) {

            if (alumnoModelo.validaCarga(this.alumnoVista.getTfNombre().getText()) || alumnoModelo.validaCarga(this.alumnoVista.getTfApellido().getText()) || alumnoModelo.validaCarga(this.alumnoVista.getTfDNI().getText())) {

                JOptionPane.showMessageDialog(null, "Los campos de DNI, nombre y apellido son obligatorios");

            } else if (alumnoModelo.validaDNI(this.alumnoVista.getTfDNI().getText())) {
                JOptionPane.showMessageDialog(null, "El DNI no es válido");

            } else {
                this.alumnoModelo.setAlu_dni(Long.parseLong(this.alumnoVista.getTfDNI().getText()));
                this.alumnoModelo.setAlu_nombre(this.alumnoVista.getTfNombre().getText());
                this.alumnoModelo.setAlu_apellido(this.alumnoVista.getTfApellido().getText());
                this.alumnoModelo.setAlu_fec_nac(new Date(this.alumnoVista.getDataChooser().getDate().getTime()));
                this.alumnoModelo.setAlu_domicilio(this.alumnoVista.getTfDomicilio().getText());
                this.alumnoModelo.setAlu_telefono(this.alumnoVista.getTfTelefono().getText());
                try {
                    if (alumnoModelo.dniRepetido(alumnoModelo)) {
                        if (this.alumnoModelo.cargaDatos(alumnoModelo)) {
                            JOptionPane.showMessageDialog(null, "Alumno cargado correctamente");
                        }
                        this.limpiarTabla(this.alumnoVista.getjTableAlu());
                        llenarFilas(this.alumnoVista.getjTableAlu());
                        limpiaCuadros();
                    } else {
                        JOptionPane.showMessageDialog(null, "Alumno repetido");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (evento.getSource().equals(this.alumnoVista.getBotonVolver())) {
            vista.VistaMenuPrincipal menuVista = new vista.VistaMenuPrincipal();
            ControladorMenuPrincipal menuControlador = new ControladorMenuPrincipal(menuVista);
            this.alumnoVista.dispose();

        } else if (evento.getSource().equals(this.alumnoVista.getBotonEliminar())) {
            try {
                if (this.alumnoModelo.baja(this.alumnoVista.getjTableAlu())) {
                    limpiarTabla(this.alumnoVista.getjTableAlu());
                    llenarFilas(this.alumnoVista.getjTableAlu());
                    JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente");
                    limpiaCuadros();
                    this.alumnoVista.getTfDNI().setEditable(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (evento.getSource().equals(this.alumnoVista.getBotonModificar())) {

            this.alumnoModelo.setAlu_dni(Long.parseLong(this.alumnoVista.getTfDNI().getText()));
            this.alumnoModelo.setAlu_nombre(this.alumnoVista.getTfNombre().getText());
            this.alumnoModelo.setAlu_apellido(this.alumnoVista.getTfApellido().getText());
            this.alumnoModelo.setAlu_fec_nac(new Date(this.alumnoVista.getDataChooser().getDate().getTime()));
            this.alumnoModelo.setAlu_domicilio(this.alumnoVista.getTfDomicilio().getText());
            this.alumnoModelo.setAlu_telefono(this.alumnoVista.getTfTelefono().getText());
            try {
                if (this.alumnoModelo.modifica(alumnoModelo)) {
                    JOptionPane.showMessageDialog(null, "Alumno modificado correctamente");
                }
            } catch (Exception ex) {
                Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.limpiarTabla(this.alumnoVista.getjTableAlu());
            try {
                llenarFilas(this.alumnoVista.getjTableAlu());
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
            limpiaCuadros();
            this.alumnoVista.getTfDNI().setEditable(true);
        }

    }

    public String[] dameColumnas() {
        String[] Columna = {"DNI", "Nombre", "Apellido", "Fecha de nacimiento", "Domicilio", "Telefono"};
        return Columna;
    }

    public void limpiarTabla(JTable tabla) {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public void llenarFilas(JTable tabla) throws SQLException {
        modeloTabla = new DefaultTableModel(null, dameColumnas());
        ArrayList<modelo.ModeloAlumno> alumnos;
        alumnos = this.alumnoModelo.traeAlumnos();
        this.limpiarTabla(this.alumnoVista.getjTableAlu());
        Object datos[] = new Object[6];
        if (alumnos.size() > 0) {
            for (int i = 0; i < alumnos.size(); i++) {
                datos[0] = alumnos.get(i).getAlu_dni();
                datos[1] = alumnos.get(i).getAlu_nombre();
                datos[2] = alumnos.get(i).getAlu_apellido();
                datos[3] = alumnos.get(i).getAlu_fec_nac();
                datos[4] = alumnos.get(i).getAlu_domicilio();
                datos[5] = alumnos.get(i).getAlu_telefono();
                modeloTabla.addRow(datos);
            }
        }

        tabla.setModel(modeloTabla);
        alumnos.clear();

    }

    public void limpiaCuadros() {
        this.alumnoVista.getTfNombre().setText("");
        this.alumnoVista.getTfApellido().setText("");
        this.alumnoVista.getTfDNI().setText("");
        this.alumnoVista.getTfDomicilio().setText("");
        this.alumnoVista.getTfTelefono().setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            int fila = this.alumnoVista.getjTableAlu().rowAtPoint(e.getPoint());
            if (fila > -1) {
                this.alumnoVista.getTfDNI().setText(String.valueOf(this.alumnoVista.getjTableAlu().getValueAt(fila, 0)));
                this.alumnoVista.getTfDNI().setEditable(false);
                this.alumnoVista.getTfNombre().setText(String.valueOf(this.alumnoVista.getjTableAlu().getValueAt(fila, 1)));
                this.alumnoVista.getTfApellido().setText(String.valueOf(this.alumnoVista.getjTableAlu().getValueAt(fila, 2)));
                this.alumnoVista.getTfDomicilio().setText(String.valueOf(this.alumnoVista.getjTableAlu().getValueAt(fila, 4)));
                this.alumnoVista.getTfTelefono().setText(String.valueOf(this.alumnoVista.getjTableAlu().getValueAt(fila, 5)));
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
}
