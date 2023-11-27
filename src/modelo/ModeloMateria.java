package modelo;

import datos.MateriaDAO;
import java.util.ArrayList;
import javax.swing.JTable;

public class ModeloMateria {

    private int codigo;
    private String nombre;
    private long dniProfesor;
    private MateriaDAO materiaDAO = new MateriaDAO();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDniProfesor() {
        return dniProfesor;
    }

    public void setDniProfesor(long dniProfesor) {
        this.dniProfesor = dniProfesor;
    }

    public MateriaDAO getMateriaDAO() {
        return materiaDAO;
    }

    public void setMateriaDAO(MateriaDAO materiaDAO) {
        this.materiaDAO = materiaDAO;
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

    public ArrayList<modelo.ModeloMateria> listarMaterias() {
        return materiaDAO.listarMateriasDAO();
    }

    public boolean cargaDatos(ModeloMateria materia) {
        return materiaDAO.cargarMateria(materia);
    }

    public boolean baja(JTable tabla) {
        return materiaDAO.eliminarMateria(tabla);
    }

    public boolean modifica(modelo.ModeloMateria materia) {
        return materiaDAO.modificarMateria(materia);
    }
}
