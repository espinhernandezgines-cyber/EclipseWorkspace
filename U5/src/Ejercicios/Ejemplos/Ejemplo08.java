package Ejercicios.Ejemplos;

import java.util.Scanner;

public class Ejemplo08 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// Ejemplo con el método substring
		System.out.print("Introduce una frase: ");
		String frase = teclado.nextLine().trim();
		System.out.println("Frase: " + frase);
		
		// Utilizando algún método visto anteriormente y el substring, mostrar una cadena que excluya la primera y última palabra, por lo que hay que insertar al menos 3 palabras en la frase
		int inicio = frase.indexOf(" ");
		int fin = frase.lastIndexOf(" ");
		if(inicio > 0 && fin > 0 && inicio < fin) { // Comprobaciones para evitar excepciones
			String subcadena = frase.substring(inicio+1, fin);
			System.out.println(subcadena);
		}
	}
}
