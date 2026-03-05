package Ejercicios.Ejemplos;

import java.util.Scanner;

public class Ejemplo06 {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		// Ejemplo con el método contains
		System.out.print("Introduce una frase: ");
		String frase = teclado.nextLine().trim();
		
		System.out.print("Introduce una palabra a comprobar dentro de la frase anterior: ");
		String subcadena = teclado.nextLine().trim();
		
		// Indicar al usuario con un mensaje si la subcadena está o no dentro del primer string. Utilizar contains. Además, que no tenga en cuenta mayúsculas y minúsculas
		boolean resultado = frase.toUpperCase().contains(subcadena.toUpperCase());
		if(resultado) {
			System.out.println("La subcadena SÍ está dentro de la frase");
		} else {
			System.out.println("La subcadena NO está dentro de la frase");
		}
		
	}

}
