import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SesionTest {
	
	Sesion miSesion = new Sesion();

	@Test
	void testLoginAlumno1Correcto() {
		assertTrue(miSesion.login("dmunuera", "123456"));
	}
	
	@Test
	void testLoginAlumno2Correcto() {
		assertTrue(miSesion.login("pepe", "654321"));
	}
	
	@Test
	void testLoginContraseñaIncorrecta() {
		assertFalse(miSesion.login("dmunuera", "999"));
	}
	
	@Test
	void testLoginUsuarioNoExiste() {
		assertFalse(miSesion.login("Yailin", "666"));
	}

}
