package Ejercicios.Ejemplos;

import java.util.Scanner;

public class Ejemplo05 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// Ejemplo con el método format
		String mensaje = "Te llamas %s %s y tienes %d años";
		
		System.out.print("Nombre: ");
		String nombre = teclado.nextLine().trim();
		System.out.print("Apellidos: ");
		String apellidos = teclado.nextLine().trim();
		System.out.print("Edad: ");
		int edad = Integer.parseInt(teclado.nextLine().trim());
		
		System.out.println( String.format(mensaje, nombre, apellidos, edad) );
	}

}
