package utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    // ---------- PRUEBAS esTriangulo() ----------

    @Test
    void testEsTrianguloValido() {
        // Comprueba que tres lados válidos forman un triángulo
        assertTrue(Utils.esTriangulo(3, 4, 5));
    }

    @Test
    void testEsTrianguloInvalido() {
        // Comprueba que valores inválidos no forman un triángulo
        assertFalse(Utils.esTriangulo(1, 2, 10));
    }

    // ---------- PRUEBAS tipoTriangulo() ----------

    @Test
    void testTrianguloEquilatero() {
        // Todos los lados iguales
        assertEquals("EQUILATERO", Utils.tipoTriangulo(5, 5, 5));
    }

    @Test
    void testTrianguloIsosceles() {
        // Dos lados iguales
        assertEquals("ISOSCELES", Utils.tipoTriangulo(5, 5, 3));
    }

    @Test
    void testTrianguloEscaleno() {
        // Todos los lados diferentes
        assertEquals("ESCALENO", Utils.tipoTriangulo(3, 4, 5));
    }

    @Test
    void testTrianguloError() {
        // No cumple la condición de triángulo
        assertEquals("ERROR", Utils.tipoTriangulo(1, 2, 8));
    }

    // ---------- PRUEBAS masFrecuenteInt() ----------

    @Test
    void testMasFrecuenteInt() {
        // Comprueba que devuelve el número que más se repite
        int[] array = {4, 1, 1, 4, 2, 3, 4, 4, 1, 2, 4, 9, 3};
        assertEquals(4, Utils.masFrecuenteInt(array));
    }

    // ---------- PRUEBAS buscarInt() ----------

    @Test
    void testBuscarIntEncontrado() {
        // Comprueba que devuelve el índice correcto
        int[] array = {10, 20, 30, 40};
        assertEquals(2, Utils.buscarInt(array, 30));
    }

    @Test
    void testBuscarIntNoEncontrado() {
        // Comprueba que devuelve -1 si no existe el valor
        int[] array = {10, 20, 30, 40};
        assertEquals(-1, Utils.buscarInt(array, 99));
    }
}