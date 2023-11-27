
package datos;

import java.util.ArrayList;
import modelo.ModeloAlumno;
import org.junit.Assert;
import org.junit.Test;


public class AlumnoDAOTest {
    
    @Test
    public void guardarAlumnoTest() throws Exception {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        ModeloAlumno alumno = new ModeloAlumno();
        alumno.setAlu_dni(123456789);
        alumno.setAlu_nombre("John");
        alumno.setAlu_apellido("Doe");

        boolean resultado = alumnoDAO.cargarAlumno(alumno);
        Assert.assertTrue(resultado);
    }

    @Test
    public void listarAlumnosTest() {
        AlumnoDAO alumnoDAO = new AlumnoDAO();

        ArrayList<ModeloAlumno> alumnos = null;
        try {
            alumnos = alumnoDAO.listarAlumnos();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(alumnos);
    }
    
}
