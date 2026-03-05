package Ejercicios.Ejemplos;

import java.util.Scanner;

public class Ejemplo11 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {				
		// Ejemplo de split con el limit
		System.out.print("Introduce una frase: ");
		String frase = teclado.nextLine().trim();
		
		// El segundo parámetro sirve para indicar la longitud máxima del array de string generado por el split
		String[] partes = frase.split(" ", 3);
		for(int i = 0; i < partes.length; i++) {
			System.out.println((i+1) + ": " + partes[i]);
		}
	}
}
