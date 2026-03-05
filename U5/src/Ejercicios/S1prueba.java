package Ejercicios;
import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class S1prueba {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un texto: ");
		String texto = teclado.nextLine();
		
		String regex = "\\b[a-zA-ZñÑ]*[aAeEiIíÍ][rR]\\b";
		
		String nuevoTexto = texto.replaceAll(regex, "(Verbo)");
		
		System.out.println("El texto cambiado es: " + nuevoTexto);
		
		boolean exito = escribir(nuevoTexto);
		if(exito) {
			System.out.println("Texto guardado en el fichero.");
		} else { System.out.println("Error al guardar texto en el fichero."); }
		
	}
	
	public static boolean escribir(String nuevoTexto) {
		Date fecha = new Date();
		try {
			FileWriter fichero = new FileWriter("./frases/" + fecha.getTime() + ".txt", true);
			fichero.write(nuevoTexto);
			fichero.close();
			return true;
		} catch (Exception e) { return false; }
	}

}
