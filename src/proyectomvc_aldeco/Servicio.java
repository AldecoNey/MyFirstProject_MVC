
package proyectomvc_aldeco;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servicio extends SQLQuery{
    public void verTodos(){
        try {
            this.conectar("127.0.0.1", "sgaprog2", "root", "mysql");
            this.consulta = this.conexion.prepareStatement("SELECT alu_dni, alu_nombre FROM alumno");
            this.datos = this.consulta.executeQuery();
            while(this.datos.next()){
                System.out.println("id: " + this.datos.getInt("alu_dni") + " nombre: " + this.datos.getString("alu_nombre"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
