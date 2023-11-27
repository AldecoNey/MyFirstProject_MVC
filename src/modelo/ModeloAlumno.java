package modelo;

import datos.AlumnoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JTable;

public class ModeloAlumno {

    private long alu_dni;
    private String alu_nombre;
    private String alu_apellido;
    private String alu_domicilio;
    private String alu_telefono;
    private Date alu_fec_nac;
    private int alu_insc_cod;
    private AlumnoDAO alumnoDAO = new AlumnoDAO();

    public long getAlu_dni() {
        return alu_dni;
    }

    public void setAlu_dni(long alu_dni) {
        this.alu_dni = alu_dni;
    }

    public String getAlu_nombre() {
        return alu_nombre;
    }

    public void setAlu_nombre(String alu_nombre) {
        this.alu_nombre = alu_nombre;
    }

    public String getAlu_apellido() {
        return alu_apellido;
    }

    public void setAlu_apellido(String alu_apellido) {
        this.alu_apellido = alu_apellido;
    }

    public String getAlu_domicilio() {
        return alu_domicilio;
    }

    public void setAlu_domicilio(String alu_domicilio) {
        this.alu_domicilio = alu_domicilio;
    }

    public String getAlu_telefono() {
        return alu_telefono;
    }

    public void setAlu_telefono(String alu_telefono) {
        this.alu_telefono = alu_telefono;
    }

    public Date getAlu_fec_nac() {
        return alu_fec_nac;
    }

    public void setAlu_fec_nac(Date alu_fec_nac) {
        this.alu_fec_nac = alu_fec_nac;
    }

    public AlumnoDAO getAlumnoDAO() {
        return alumnoDAO;
    }

    public void setAlumnoDAO(AlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }

    public int getAlu_insc_cod() {
        return alu_insc_cod;
    }

    public void setAlu_insc_cod(int alu_insc_cod) {
        this.alu_insc_cod = alu_insc_cod;
    }

    public boolean cargaDatos(ModeloAlumno alumno) throws Exception {
        return alumnoDAO.cargarAlumno(alumno);
    }

    public ArrayList<ModeloAlumno> traeAlumnos() throws SQLException {

        return alumnoDAO.listarAlumnos();

    }

    public boolean baja(JTable tabla) throws SQLException {
        return alumnoDAO.bajaDAO(tabla);

    }

    public boolean modifica(ModeloAlumno alumno) throws Exception {
        return alumnoDAO.modificarAlumno(alumno);
    }

    public boolean validaDNI(String a) {

        try {
            alu_dni = Long.parseLong(a);
            return false;
        } catch (NumberFormatException nfe) {
            return true;
        }
    }

    public boolean dniRepetido(ModeloAlumno alumno) throws SQLException {
        return !alumnoDAO.DNIRepetido(alumno.getAlu_dni());
    }

    public boolean validaCarga(String a) {
        if (a.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
