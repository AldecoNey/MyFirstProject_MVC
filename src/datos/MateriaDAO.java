package datos;

import java.sql.SQLException;
import modelo.ModeloMateria;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;

public class MateriaDAO extends SQLQuery {

    private modelo.ModeloMateria materia;
    private ArrayList<modelo.ModeloMateria> materias;

    public ArrayList<ModeloMateria> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<ModeloMateria> materias) {
        this.materias = materias;
    }

    public boolean cargarMateria(modelo.ModeloMateria materia) {
        try {
            this.conectar();

            // Obtener el último valor de mat_cod
            int ultimoCodigo = obtenerUltimoCodigo();

            // Generar el siguiente valor para mat_cod
            int siguienteCodigo = ultimoCodigo + 1;

            // Asignar el valor generado a la instancia de 'materia'
            materia.setCodigo(siguienteCodigo);

            // Realizar la inserción en la base de datos
            String sql = "INSERT INTO materia (mat_cod, mat_nombre) VALUES (?, ?)";
            PreparedStatement preparedStmt = (PreparedStatement) this.conexion.prepareStatement(sql);
            preparedStmt.setInt(1, materia.getCodigo());
            preparedStmt.setString(2, materia.getNombre());
            preparedStmt.execute();

            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private int obtenerUltimoCodigo() throws ClassNotFoundException, SQLException {
        int ultimoCodigo = 0;
        this.consulta = this.conexion.prepareStatement("SELECT MAX(mat_cod) FROM materia");
        ResultSet resultado = this.consulta.executeQuery();
        if (resultado.next()) {
            ultimoCodigo = resultado.getInt(1);
        }
        return ultimoCodigo;
    }

    public ArrayList<modelo.ModeloMateria> listarMateriasDAO() {
        materias = new ArrayList();
        try {
            this.conectar();
            this.consulta = this.conexion.prepareStatement("select * from materia");
            ResultSet hojadeResultados = consulta.executeQuery();

            while (hojadeResultados.next()) {
                materia = new modelo.ModeloMateria();
                materia.setCodigo(hojadeResultados.getInt(1));
                materia.setNombre(hojadeResultados.getString(2));
                materia.setDniProfesor(hojadeResultados.getLong(3));
                materias.add(materia);
            }
            this.desconectar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return materias;
    }

    public boolean eliminarMateria(JTable tabla) {
        int seleccion;
        materias = new ArrayList(listarMateriasDAO());
        try {
            this.conectar();
            this.consulta = this.conexion.prepareStatement("DELETE FROM materia WHERE mat_cod = ?");
            seleccion = tabla.getSelectedRow();
            this.consulta.setLong(1, materias.get(seleccion).getCodigo());
            consulta.executeUpdate();
            this.desconectar();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public boolean modificarMateria(modelo.ModeloMateria materia) {
        try {
            this.conectar();
            PreparedStatement preparedStmt = (PreparedStatement) this.conexion.prepareStatement("UPDATE materia SET mat_nombre=? WHERE mat_cod=?");
            preparedStmt.setString(1, materia.getNombre());
            preparedStmt.setInt(2, materia.getCodigo());
            preparedStmt.executeUpdate();
            this.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
