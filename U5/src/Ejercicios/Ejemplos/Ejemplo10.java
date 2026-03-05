package Ejercicios.Ejemplos;

import java.util.Scanner;

public class Ejemplo10 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {				
		// Ejemplo de convertir String a un array de char
		System.out.print("Introduce una frase: ");
		String frase = teclado.nextLine().trim();
		
		char[] letras = frase.toCharArray();
		
		for(int i = 0; i < letras.length; i++) {
			System.out.print(letras[i] + " ");
		}
	}
}
