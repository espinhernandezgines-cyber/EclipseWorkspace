package Ejercicios;
import java.util.Scanner;
import java.util.regex.*;
/*Ejercicio 1
Crea un programa que pida un nombre de usuario e indique si es válido de acuerdo al siguiente formato:

Debe tener una longitud de entre 3 y 20 caracteres
Debe empezar por un carácter alfabético, mayúscula o minúscula
A partir del segundo carácter puede contener mayúsculas, minúsculas, números, y caracteres especiales como( _ # $ % ? = + -) */

public class Ex1 {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca un nombre de usuario: ");
		String username = teclado.nextLine().trim();
		
		String regex = "^[A-Za-z][A-Za-z0-9_#$%?=+-]{2,19}";
		if(username.matches(regex)) {
			System.out.println("Válido.");
		}else {
			System.out.println("No válido");
		}
	}
}
