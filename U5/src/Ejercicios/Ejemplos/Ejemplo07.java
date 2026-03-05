package Ejercicios.Ejemplos;

import java.util.Scanner;

public class Ejemplo07 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// Ejemplo con el método join
		String[] nombreCompleto = {"Francisco", "Javier", "Perez", "Martinez"};
		// Primero apellidos y nombre
		System.out.println("El nombre completo es: " + String.join(" ", nombreCompleto[2], nombreCompleto[3], nombreCompleto[0], nombreCompleto[1]));
		
		// Pasandole el array completo
		System.out.println("El nombre completo es: " + String.join(" ", nombreCompleto));
	}
}
