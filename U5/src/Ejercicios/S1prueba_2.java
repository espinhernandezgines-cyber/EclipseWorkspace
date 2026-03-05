package Ejercicios;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;

public class S1prueba_2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un texto por teclado: ");
		String texto = teclado.nextLine();
		
		String regex = "\\b[a-zA-ZñÑ]*[aAeEiIíÍ][rR]\\b";
		
		String nuevoTexto = texto.replaceAll(regex, "(Verbo)");
		
		System.out.println(nuevoTexto);
		
		boolean exito = escribir(nuevoTexto);
		
		if(exito) {
			System.out.println("Texto escrito en el fichero.");
		} else {
			System.out.println("Error escribiendo en el fichero.");
		}
		
		teclado.close();
	}
	
	public static boolean escribir(String nuevoTexto) {
		Date fecha = new Date();
		try {
			FileWriter fichero = new FileWriter("./frases/" + fecha.getTime() + ".txt", true );
			fichero.write(nuevoTexto);
			fichero.close();
			return true;
		} catch (Exception e) {
			System.out.println("ERROR");
			return false;
		}
	}

}
