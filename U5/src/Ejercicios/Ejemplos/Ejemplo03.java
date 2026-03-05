package Ejercicios.Ejemplos;

import java.util.Scanner;

public class Ejemplo03 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// Ejemplo con el método indexOf
		System.out.print("Introduce una frase: ");
		String frase = teclado.nextLine().trim();
		
		System.out.print("Introduce una palabra a buscar dentro de la frase anterior: ");
		String subcadena = teclado.nextLine().trim();
		
		// Indicar al usuario con un mensaje en qué posición empieza la subcadena o si la subcadena no está dentro del primer string. Utilizar indexOf
		int indice = frase.indexOf(subcadena);
		if(indice >= 0) {
			System.out.println("La palabra que buscas está en el índice " + indice);
		} else {
			System.out.println("No se ha encontrado la palabra dentro de la frase.");
		}
	}

}
