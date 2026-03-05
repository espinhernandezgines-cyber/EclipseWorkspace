import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstudianteTest {
	
	private Estudiante estudiante1;
	private Estudiante estudiante2;
	private Estudiante estudiante3;
	
	@BeforeEach
	public void crearEstudiantes() {
		estudiante1 = new Estudiante("mk",20,0.1); //Suspensa
		estudiante2 = new Estudiante("mj",45,9); //Sobresaliente
		estudiante3 = new Estudiante("mnm",68,6.66); //Aprobado
		
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("mk", estudiante1.getNombre());
		assertEquals("mj", estudiante2.getNombre());
		assertEquals("mnm", estudiante3.getNombre());
	}
	
	@Test
	public void testGetEdad() {
		assertEquals(20, estudiante1.getEdad());
		assertEquals(45, estudiante2.getEdad());
		assertEquals(68, estudiante3.getEdad());
	}
	
	@Test
	public void testGetNota() {
		assertEquals(0.1, estudiante1.getNota());
		assertEquals(9, estudiante2.getNota());
		assertEquals(6.66, estudiante3.getNota());
	}
	
	@Test
	public void testObtenerEstadoAcademico() {
		assertEquals("Suspenso", estudiante1.obtenerEstadoAcademico());
		assertEquals("Sobresaliente", estudiante2.obtenerEstadoAcademico());
		assertEquals("Aprobado", estudiante3.obtenerEstadoAcademico());

	}

}
