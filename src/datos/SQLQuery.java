package datos;

import java.sql.*;

public class SQLQuery {

    protected Connection conexion;
    protected PreparedStatement consulta;
    protected ResultSet datos;
    private final String usuario = "root";
    private final String password = "mysql";
    private final String db = "sgaprog2";
    private final String servidor = "127.0.0.1"; //localhost

    public void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conexion = DriverManager.getConnection("jdbc:mysql://" + servidor + "/" + db, usuario, password);
    }

    protected void consultarBase(String sql) {
        try {
            conectar();
            this.consulta = conexion.prepareStatement(sql);
            this.datos = consulta.executeQuery();

        } catch (Exception e) {

        }
    }

    protected void insertarModificarEliminar(String sql) {
        try {

            conectar();
            consulta = conexion.prepareStatement(sql);
            consulta.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void desconectar() {
        try {
            if (consulta != null) {
                consulta.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (datos != null) {
                datos.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
