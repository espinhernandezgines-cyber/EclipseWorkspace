package Ejercicios.Ejemplos;

import java.util.Scanner;

public class Ejemplo12 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// Ejemplo de replaceAll
		System.out.print("Introduce una frase: ");
		String frase = teclado.nextLine().trim();

		System.out.print("Indica la palabra que quieres cambiar: ");
		String palabra = teclado.nextLine().trim();

		System.out.print("Indica la nueva palabra: ");
		String nueva = teclado.nextLine().trim();

		String nuevaFrase = frase.replaceAll(palabra, nueva);
		System.out.println(frase);
		System.out.println(nuevaFrase);
	}
}
