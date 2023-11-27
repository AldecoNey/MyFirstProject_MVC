package controlador;

import java.awt.Color;
import modelo.ModeloCursado;
import vista.VistaCursado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControladorCursado implements ActionListener, MouseListener, ItemListener {

    private modelo.ModeloCursado cursadoModelo;
    private vista.VistaCursado cursadoVista;
    private DefaultTableModel modeloTabla;
    private modelo.ModeloAlumno alumno = new modelo.ModeloAlumno();
    private modelo.ModeloMateria materia = new modelo.ModeloMateria();

    public ControladorCursado(ModeloCursado notaModelo, VistaCursado notaVista) {
        this.cursadoModelo = notaModelo;
        this.cursadoVista = notaVista;
        this.cursadoVista.setVisible(true);
        this.llenarFilas(this.cursadoVista.getjTableCurs());
        llenaComboBoxAlumno();
        llenaComboBoxMateria();
        this.cursadoModelo.setAlumno(alumno);
        this.cursadoModelo.setMateria(materia);
        escucharBotones();
        agregarEventoMouse(this.cursadoVista.getJBAgregar());
        agregarEventoMouse(this.cursadoVista.getJBEliminar());
        agregarEventoMouse(this.cursadoVista.getJBModificar());
        agregarEventoMouse(this.cursadoVista.getJBVolver());
        agregarEventoMouseBorrarTexto(this.cursadoVista.getJtNota());
    }

    public void escucharBotones() {
        this.cursadoVista.getJBAgregar().addActionListener(this);
        this.cursadoVista.getJBEliminar().addActionListener(this);
        this.cursadoVista.getJBModificar().addActionListener(this);
        this.cursadoVista.getjTableCurs().addMouseListener(this);
        this.cursadoVista.getJBVolver().addActionListener(this);
        this.cursadoVista.getjCBCodigoMateria().addItemListener(this);
        this.cursadoVista.getjCBDniAlumno().addItemListener(this);
    }

    public void agregarEventoMouse(JButton boton) {
        boton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                boton.setBackground(new Color(0, 122, 0));
            }

            public void mouseExited(MouseEvent evento) {
                boton.setBackground(new Color(0,153,0));
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
        if (evento.getSource().equals(this.cursadoVista.getJBAgregar())) {
            if (cursadoModelo.validaCarga(this.cursadoVista.getjCBCodigoMateria().toString()) || cursadoModelo.validaCarga(this.cursadoVista.getjCBDniAlumno().toString())) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un dni de alumno y un codigo materia");
            } else if (cursadoModelo.validaNota(Integer.parseInt(this.cursadoVista.getJtNota().getText()))) {
                this.cursadoModelo.getAlumno().setAlu_dni(Long.parseLong(this.cursadoVista.getjCBDniAlumno().getSelectedItem().toString()));
                this.cursadoModelo.getMateria().setCodigo(Integer.parseInt(this.cursadoVista.getjCBCodigoMateria().getSelectedItem().toString()));
                this.cursadoModelo.setNota(Integer.parseInt(this.cursadoVista.getJtNota().getText()));
                if (cursadoModelo.notaRepetida(cursadoModelo)) {
                    try {
                        if (this.cursadoModelo.cargaDatos(cursadoModelo)) {
                            JOptionPane.showMessageDialog(null, "Nota cargada");
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ControladorCursado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.limpiarTabla(this.cursadoVista.getjTableCurs());
                    llenarFilas(this.cursadoVista.getjTableCurs());
                    limpiaCuadros();

                } else {
                    JOptionPane.showMessageDialog(null, "Nota repetida");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La nota debe estar entre 1 y 10");
            }
        } else if (evento.getSource().equals(this.cursadoVista.getJBEliminar())) {
            if (this.cursadoModelo.baja(this.cursadoVista.getjTableCurs())) {
                limpiarTabla(this.cursadoVista.getjTableCurs());
                llenarFilas(this.cursadoVista.getjTableCurs());
                JOptionPane.showMessageDialog(null, "Nota eliminada correctamente");
                limpiaCuadros();
            }

        } else if (evento.getSource().equals(this.cursadoVista.getJBModificar())) {
            this.cursadoModelo.getAlumno().setAlu_dni(Long.parseLong(this.cursadoVista.getjCBDniAlumno().getSelectedItem().toString()));
            this.cursadoModelo.getMateria().setCodigo(Integer.parseInt(this.cursadoVista.getjCBCodigoMateria().getSelectedItem().toString()));
            this.cursadoModelo.setNota(Integer.parseInt(this.cursadoVista.getJtNota().getText()));
            if (this.cursadoModelo.modifica(cursadoModelo)) {
                JOptionPane.showMessageDialog(null, "Nota modificada");
            }
            this.limpiarTabla(this.cursadoVista.getjTableCurs());
            llenarFilas(this.cursadoVista.getjTableCurs());
            limpiaCuadros();

        } else if (evento.getSource().equals(this.cursadoVista.getJBVolver())) {
            vista.VistaMenuPrincipal menuVista = new vista.VistaMenuPrincipal();
            controlador.ControladorMenuPrincipal menuControlador = new ControladorMenuPrincipal(menuVista);
            this.cursadoVista.dispose();
        }
    }

    public void llenaComboBoxAlumno() {
        ArrayList<String> dni = this.cursadoModelo.traeDNIAlumno();
        Iterator<String> dniIterator = dni.iterator();
        while (dniIterator.hasNext()) {
            this.cursadoVista.getjCBDniAlumno().addItem(dniIterator.next());
        }
    }

    public void llenaComboBoxMateria() {
        ArrayList<String> materia = this.cursadoModelo.traeCodigoMateria();
        Iterator<String> materiaIterator = materia.iterator();
        while (materiaIterator.hasNext()) {
            this.cursadoVista.getjCBCodigoMateria().addItem(materiaIterator.next());
        }
    }

    public void llenarFilas(JTable tabla) {
        modeloTabla = new DefaultTableModel(null, dameColumnas());
        ArrayList<modelo.ModeloCursado> notas;
        notas = this.cursadoModelo.traeNotas();
        this.limpiarTabla(this.cursadoVista.getjTableCurs());
        Object datos[] = new Object[3];
        if (notas.size() > 0) {
            for (int i = 0; i < notas.size(); i++) {
                datos[0] = notas.get(i).getAlumno().getAlu_dni();
                datos[1] = notas.get(i).getMateria().getCodigo();
                datos[2] = notas.get(i).getNota();
                modeloTabla.addRow(datos);
            }
        }
        tabla.setModel(modeloTabla);
        notas.clear();

    }

    public void limpiarTabla(JTable tabla) {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public String[] dameColumnas() {
        String[] Columna = {"DNI Alumno", "Codigo Materia", "Nota"};
        return Columna;
    }

    public void limpiaCuadros() {
        this.cursadoVista.getJtNota().setText("");
        this.cursadoVista.getjCBCodigoMateria().setSelectedIndex(0);
        this.cursadoVista.getjCBCodigoMateria().setEnabled(true);
        this.cursadoVista.getjCBDniAlumno().setSelectedIndex(0);
        this.cursadoVista.getjCBDniAlumno().setEnabled(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            int fila = this.cursadoVista.getjTableCurs().rowAtPoint(e.getPoint());
            if (fila > -1) {
                this.cursadoVista.getjCBDniAlumno().setSelectedItem(String.valueOf(this.cursadoVista.getjTableCurs().getValueAt(fila, 0)));
                this.cursadoVista.getjCBDniAlumno().setEnabled(false);
                this.cursadoVista.getjCBCodigoMateria().setSelectedItem(String.valueOf(this.cursadoVista.getjTableCurs().getValueAt(fila, 1)));
                this.cursadoVista.getjCBCodigoMateria().setEnabled(false);
                this.cursadoVista.getJtNota().setText(String.valueOf(this.cursadoVista.getjTableCurs().getValueAt(fila, 2)));

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
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getItemSelectable().equals(this.cursadoVista.getjCBCodigoMateria()) && !this.cursadoVista.getjCBCodigoMateria().getSelectedItem().equals("")) {
            int eleccion = Integer.parseInt(this.cursadoVista.getjCBCodigoMateria().getSelectedItem().toString());
            this.materia = this.cursadoModelo.traeMateria(eleccion);
        } else if (ie.getItemSelectable().equals(this.cursadoVista.getjCBDniAlumno()) && !this.cursadoVista.getjCBDniAlumno().getSelectedItem().equals("")) {

        }
    }

}
