package datos;

import java.sql.Date;
import modelo.ModeloAlumno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class AlumnoDAO extends SQLQuery {

    private ArrayList<ModeloAlumno> alumnos = new ArrayList();
    private ModeloAlumno alumno;

    public boolean cargarAlumno(ModeloAlumno alu) throws Exception {
        try {
            String sql = "INSERT INTO alumno (alu_dni, alu_nombre, alu_apellido, alu_fec_nac, alu_domicilio, alu_telefono) VALUES (?, ?, ?, ?, ?, ?)";
            conectar();
            consulta = conexion.prepareStatement(sql);
            consulta.setLong(1, alu.getAlu_dni());
            consulta.setString(2, alu.getAlu_nombre());
            consulta.setString(3, alu.getAlu_apellido());
            consulta.setDate(4, (Date) alu.getAlu_fec_nac());
            consulta.setString(5, alu.getAlu_domicilio());
            consulta.setString(6, alu.getAlu_telefono());
            consulta.executeUpdate();
            desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validarInscripcionExistente(int codigoInscripcion) {
        boolean inscripcionValida = false;

        try {
            this.conectar();

            // Realiza una consulta para verificar si el código de inscripción existe en la tabla "inscripcion"
            String sql = "SELECT COUNT(*) FROM inscripcion WHERE insc_cod = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, codigoInscripcion);
            ResultSet resultSet = statement.executeQuery();

            // Comprueba si se encontró algún registro con el código de inscripción
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                inscripcionValida = true; // El código de inscripción existe y es válido
            }

            this.desconectar();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return inscripcionValida;
    }

    public ArrayList<ModeloAlumno> listarAlumnos() throws SQLException {
        try {
            String sql = "SELECT * FROM alumno";
            consultarBase(sql);
            while (this.datos.next()) {
                alumno = new ModeloAlumno();
                this.alumno.setAlu_dni(datos.getLong("alu_dni"));
                this.alumno.setAlu_nombre(datos.getString("alu_nombre"));
                this.alumno.setAlu_apellido(datos.getString("alu_apellido"));
                this.alumno.setAlu_fec_nac(datos.getDate("alu_fec_nac"));
                this.alumno.setAlu_domicilio(datos.getString("alu_domicilio"));
                this.alumno.setAlu_telefono(datos.getString("alu_telefono"));
                this.alumno.setAlu_insc_cod(datos.getInt("alu_insc_cod"));
                this.alumnos.add(alumno);
            }

            this.desconectar();
        } catch (Exception e) {

            this.desconectar();
            e.printStackTrace();
        } finally {
            return alumnos;
        }
    }

    public boolean bajaDAO(JTable tabla) throws SQLException {
        int seleccion;
        alumnos = new ArrayList(listarAlumnos());
        try {
            this.conectar();
            this.consulta = this.conexion.prepareStatement("DELETE FROM Alumno WHERE alu_dni = ?");
            seleccion = tabla.getSelectedRow();
            this.consulta.setLong(1, alumnos.get(seleccion).getAlu_dni());
            consulta.executeUpdate();

            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean modificarAlumno(ModeloAlumno alumno) throws Exception {
        try {
            String sql = "UPDATE alumno SET alu_nombre = '" + alumno.getAlu_nombre() + "', alu_apellido = '" + alumno.getAlu_apellido() + "', alu_fec_nac = '" + alumno.getAlu_fec_nac() + "', alu_domicilio = '" + alumno.getAlu_domicilio() + "', alu_telefono = '" + alumno.getAlu_telefono() + "' WHERE alu_dni = " + alumno.getAlu_dni();
            insertarModificarEliminar(sql);
            desconectar();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean DNIRepetido(long dni) throws SQLException {
        String sql = "SELECT alu_dni FROM alumno WHERE alu_dni = " + dni;
        consultarBase(sql);
        boolean repetido = datos.next();
        desconectar();
        return repetido;
    }
}
