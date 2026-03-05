import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class CalcTest {
	
    @BeforeEach
	void antes() {
    	System.out.println("Se ejecuta antes de cada test");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

@Test
public void testSuma() {
System.out.println("Test SUMA");
}

@Test
public void testResta() {
fail("Not yet implemented");
}

@Test
public void testMultiplica() {
fail("Not yet implemented");
}

@Test
public void testDivide() {
fail("Not yet implemented");
}
}
