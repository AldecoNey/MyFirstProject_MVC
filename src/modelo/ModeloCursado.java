package modelo;

import datos.CursadoDAO;
import java.util.ArrayList;
import javax.swing.JTable;

public class ModeloCursado {

    private ModeloAlumno Alumno = new ModeloAlumno();
    private ModeloMateria Materia = new ModeloMateria();
    private int nota;
    private CursadoDAO cursadoDAO = new CursadoDAO();

    public ModeloAlumno getAlumno() {
        return Alumno;
    }

    public void setAlumno(ModeloAlumno Alumno) {
        this.Alumno = Alumno;
    }

    public ModeloMateria getMateria() {
        return Materia;
    }

    public void setMateria(ModeloMateria Materia) {
        this.Materia = Materia;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public CursadoDAO getCursadoDAO() {
        return cursadoDAO;
    }

    public void setCursadoDAO(CursadoDAO cursadoDAO) {
        this.cursadoDAO = cursadoDAO;
    }

    public boolean validaDNI(String a) {
        try {
            Long.parseLong(a);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public boolean validaCarga(String a) {
        if (a.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<modelo.ModeloCursado> listarCursado() {
        return cursadoDAO.listarCursadoDAO();
    }

    public boolean cargaDatos(ModeloCursado cursado) throws ClassNotFoundException {
        return cursadoDAO.cargarCursado(cursado);
    }

    public boolean baja(JTable tabla) {
        return cursadoDAO.eliminarCursado(tabla);
    }

    public boolean modifica(modelo.ModeloCursado cursado) {
        return cursadoDAO.modificarCursado(cursado);
    }

    public ArrayList<String> traeCodigoMateria() {
        return cursadoDAO.traeCodigoMateriaDAO();
    }

    public boolean validaNota(int nota) {
        if (nota >= 1 && nota <= 10) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<ModeloCursado> traeNotas() {
        return cursadoDAO.traeNotasDAO();
    }

    public ArrayList<String> traeDNIAlumno() {
        return cursadoDAO.traeDNIAlumnoDAO();
    }

    public boolean notaRepetida(modelo.ModeloCursado nota) {
        return !cursadoDAO.notaRepetida(nota);
    }

    public modelo.ModeloMateria traeMateria(int codigo) {
        this.Materia = cursadoDAO.traeMateriaDAO(codigo);
        return this.Materia;
    }
}
