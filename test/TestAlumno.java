
import datos.AlumnoDAO;
import java.util.ArrayList;
import modelo.ModeloAlumno;


public class TestAlumno {
    @Test
    public void guardarAlumnoTest() {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        ModeloAlumno alumno = new ModeloAlumno();
        alumno.setAlu_dni(123456789);
        alumno.setAlu_nombre("John");
        alumno.setAlu_apellido("Doe");
        // Establecer otros atributos del alumno si es necesario

        boolean resultado = alumnoDAO.cargarAlumno(alumno);
        Assertions.assertTrue(resultado);
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

        Assertions.assertNotNull(alumnos);
        // Realizar más aserciones según el resultado esperado
    }
}
