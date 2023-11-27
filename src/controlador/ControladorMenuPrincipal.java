package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.VistaAlumno;
import vista.VistaMenuPrincipal;

public class ControladorMenuPrincipal implements ActionListener {

    private VistaMenuPrincipal menu;

    public ControladorMenuPrincipal(VistaMenuPrincipal menu) {
        this.menu = menu;
        menu.setVisible(true);
        escucharBotones();
        agregarEventoMouse();
    }

    public void escucharBotones() {
        this.menu.getJbAlumnos().addActionListener(this);
        this.menu.getJbMaterias().addActionListener(this);
        this.menu.getJbCursados().addActionListener(this);
    }

    public void agregarEventoMouse() {
        this.menu.getJbAlumnos().addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evento) {
                jbAlumnosMouseEntered(evento);
            }

            public void mouseExited(MouseEvent evt) {
                jbAlumnosMouseExited(evt);
            }
        });

        this.menu.getJbMaterias().addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evento) {
                jbMateriasMouseEntered(evento);
            }

            public void mouseExited(MouseEvent evt) {
                jbMateriasMouseExited(evt);
            }
        });

        this.menu.getJbCursados().addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evento) {
                jbCursadosMouseEntered(evento);
            }

            public void mouseExited(MouseEvent evt) {
                jbCursadosMouseExited(evt);
            }
        });
    }

    private void jbAlumnosMouseEntered(MouseEvent evento) {
        menu.getJbAlumnos().setBackground(new Color(0, 122, 122));
    }

    private void jbAlumnosMouseExited(MouseEvent evento) {
        menu.getJbAlumnos().setBackground(new Color(0, 153, 153));
    }

    private void jbMateriasMouseEntered(MouseEvent evento) {
        menu.getJbMaterias().setBackground(new Color(255, 102, 102));
    }

    private void jbMateriasMouseExited(MouseEvent evento) {
        menu.getJbMaterias().setBackground(new Color(255, 153, 153));
    }

    private void jbCursadosMouseEntered(MouseEvent evento) {
        menu.getJbCursados().setBackground(new Color(0, 153, 0));
    }

    private void jbCursadosMouseExited(MouseEvent evento) {
        menu.getJbCursados().setBackground(new Color(0, 204, 51));
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource().equals(this.menu.getJbAlumnos())) {

            modelo.ModeloAlumno alumnoModelo = new modelo.ModeloAlumno();
            VistaAlumno alumnoVista = new vista.VistaAlumno();
            try {
                ControladorAlumno alumnoControlador = new controlador.ControladorAlumno(alumnoModelo, alumnoVista);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.menu.dispose();

        } else if (evento.getSource().equals(this.menu.getJbMaterias())) {
            modelo.ModeloMateria materiaModelo = new modelo.ModeloMateria();
            vista.VistaMateria materiaVista = new vista.VistaMateria();
            ControladorMateria materiaControlador = new controlador.ControladorMateria(materiaVista, materiaModelo);
            this.menu.dispose();

        } else if (evento.getSource().equals(this.menu.getJbCursados())) {
            modelo.ModeloCursado notaModelo = new modelo.ModeloCursado();
            vista.VistaCursado notaVista = new vista.VistaCursado();
            ControladorCursado notaControlador = new controlador.ControladorCursado(notaModelo, notaVista);
            this.menu.dispose();
        }
    }

}
