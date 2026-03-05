package Ejercicios.Ejemplos;

import java.util.Scanner;

public class Ejemplo04 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// Ejemplo con el método lastIndexOf
		System.out.print("Introduce una frase: ");
		String frase = teclado.nextLine().trim();
		
		System.out.print("Introduce una palabra a buscar dentro de la frase anterior: ");
		String subcadena = teclado.nextLine().trim();
		
		// Indicar al usuario con un mensaje en qué posición empieza la subcadena o si la subcadena no está dentro del primer string. Utilizar lastIndexOf
		int indice = frase.lastIndexOf(subcadena);
		if(indice >= 0) {
			System.out.println("La última ocurrencia de la palabra que estás buscando está en el índice " + indice);
		} else {
			System.out.println("No se ha encontrado la palabra dentro de la frase.");
		}
	}

}
