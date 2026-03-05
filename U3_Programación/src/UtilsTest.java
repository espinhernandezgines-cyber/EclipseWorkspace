import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testBuscarInt1() {
		int[] numeros = {1,2,3,3,5,6,4,8,9,7,3,4,5,7,9};
		int num = 4;
		int resultado = Utils.buscarInt(numeros, num);
		assertEquals(6,resultado);
	}
	
	@Test
	public void testBuscarInt2() {
		int[] numeros = {1,2,3,3,5,6,4,8,9,7,3,4,5,7,9};
		int num = 8;
		int resultado = Utils.buscarInt(numeros, num);
		assertEquals(7,resultado);
	}
	
	@Test
	public void testBuscarInt3() {
		int[] numeros = {1,2,3,3,5,6,4,8,9,7,3,4,5,7,9};
		int num = 3;
		int resultado = Utils.buscarInt(numeros, num);
		assertEquals(2,resultado);
	}

}
