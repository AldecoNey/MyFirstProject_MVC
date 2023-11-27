package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import modelo.ModeloCursado;

public class CursadoDAO extends SQLQuery {

    private modelo.ModeloCursado cursado;
    private ArrayList<modelo.ModeloCursado> cursados;

    public ArrayList<ModeloCursado> getCursados() {
        return cursados;
    }

    public void setCursados(ArrayList<ModeloCursado> cursados) {
        this.cursados = cursados;
    }

    public boolean cargarCursado(ModeloCursado cursado) throws ClassNotFoundException {
        try {
            this.conectar();
            String sql = "INSERT INTO cursado (cur_alu_dni, cur_mat_cod, cur_nota) VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = this.conexion.prepareStatement(sql);
            preparedStmt.setLong(1, cursado.getAlumno().getAlu_dni());
            preparedStmt.setInt(2, cursado.getMateria().getCodigo());
            preparedStmt.setInt(3, cursado.getNota());
            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<modelo.ModeloCursado> listarCursadoDAO() {
        cursados = new ArrayList();
        try {
            this.conectar();
            this.consulta = this.conexion.prepareStatement("select * from cursado");
            ResultSet hojadeResultados = consulta.executeQuery();

            while (hojadeResultados.next()) {
                cursado = new modelo.ModeloCursado();
                cursado.getAlumno().setAlu_dni(hojadeResultados.getLong(1));
                cursado.getMateria().setCodigo(hojadeResultados.getInt(2));
                cursado.setNota(hojadeResultados.getInt(3));
                cursados.add(cursado);
            }
            this.desconectar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cursados;
    }

    public boolean eliminarCursado(JTable tabla) {
        int seleccion;
        cursados = new ArrayList(listarCursadoDAO());
        try {
            this.conectar();
            this.consulta = this.conexion.prepareStatement("DELETE FROM cursado WHERE cur_alu_dni = ?");
            seleccion = tabla.getSelectedRow();
            this.consulta.setLong(1, cursados.get(seleccion).getAlumno().getAlu_dni());
            consulta.executeUpdate();
            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public boolean modificarCursado(modelo.ModeloCursado cursado) {
        try {
            this.conectar();
            PreparedStatement preparedStmt = (PreparedStatement) this.conexion.prepareStatement("UPDATE cursado SET cur_mat_cod=?, cur_nota=? WHERE cur_alu_dni=?");
            preparedStmt.setInt(1, cursado.getMateria().getCodigo());
            preparedStmt.setInt(2, cursado.getNota());
            preparedStmt.setLong(3, cursado.getAlumno().getAlu_dni());
            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean notaRepetida(modelo.ModeloCursado nota) {

        try {
            this.conectar();
            this.consulta = this.conexion.prepareStatement("select * from cursado where cur_alu_dni=? AND cur_mat_cod=?");
            this.consulta.setLong(1, nota.getAlumno().getAlu_dni());
            this.consulta.setInt(2, nota.getMateria().getCodigo());
            ResultSet hojadeResultados = consulta.executeQuery();
            if (hojadeResultados.next()) {
                return true;
            }
            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<ModeloCursado> traeNotasDAO() {
        cursados = new ArrayList();
        try {
            this.conectar();
            this.consulta = this.conexion.prepareStatement("select * from cursado");
            ResultSet hojadeResultados = consulta.executeQuery();

            while (hojadeResultados.next()) {
                cursado = new ModeloCursado();
                modelo.ModeloMateria materia = new modelo.ModeloMateria();
                cursado.setMateria(materia);
                modelo.ModeloAlumno alumno = new modelo.ModeloAlumno();
                cursado.setAlumno(alumno);
                cursado.getAlumno().setAlu_dni(hojadeResultados.getLong(1));
                cursado.getMateria().setCodigo(hojadeResultados.getInt(2));
                cursado.setNota(hojadeResultados.getInt(3));
                cursados.add(cursado);
            }

            this.desconectar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cursados;

    }

    public ArrayList<String> traeDNIAlumnoDAO() {
        ArrayList<String> dni = new ArrayList();
        try {
            this.conectar();
            this.consulta = this.conexion.prepareStatement("select alu_dni from alumno");
            ResultSet hojadeResultados = consulta.executeQuery();
            dni.add("");
            while (hojadeResultados.next()) {
                dni.add(Long.toString(hojadeResultados.getLong(1)));
            }
            this.desconectar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dni;
    }

    public ArrayList<String> traeCodigoMateriaDAO() {
        ArrayList<String> codigo = new ArrayList();
        try {
            this.conectar();
            this.consulta = this.conexion.prepareStatement("select mat_cod from materia");
            ResultSet hojadeResultados = consulta.executeQuery();
            codigo.add("");
            while (hojadeResultados.next()) {
                codigo.add(Integer.toString(hojadeResultados.getInt(1)));
            }
            this.desconectar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }

    public modelo.ModeloMateria traeMateriaDAO(int codigo) {

        modelo.ModeloMateria materia = new modelo.ModeloMateria();
        try {
            this.conectar();
            this.consulta = this.conexion.prepareStatement("select * from materia where mat_cod=?");
            this.consulta.setInt(1, codigo);

            ResultSet hojadeResultados = consulta.executeQuery();
            if (hojadeResultados.next()) {
                materia.setCodigo(hojadeResultados.getInt(1));
                materia.setNombre(hojadeResultados.getString(2));
            }

            this.desconectar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CursadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return materia;

    }
}
