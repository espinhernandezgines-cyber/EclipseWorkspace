package Ejercicios.Ejemplos;

import java.util.Scanner;

public class Ejemplo09 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// Ejemplo de convertir array de char a String
		char[] letras = { 'A', 'B', 'C', ' ', 'D', 'E', 'F' };

		// Si utilizamos el constructor de los String pasando un array de char,
		// convierte el array a un String sin tener que recorrerlo y concatenarlos a un
		// string
		String texto = new String(letras);

		System.out.println(texto);
	}
}
