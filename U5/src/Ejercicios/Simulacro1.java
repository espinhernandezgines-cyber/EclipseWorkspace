package Ejercicios;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.*;
/*Escribe un programa que pida un texto largo por teclado y lo procese, 
sustituyendo cada palabra que sea un verbo en infinitivo por el texto "(VERBO)".
Una vez sustituido cada verbo en infinitivo, mostrar el resultado por consola y escribirlo en un fichero en la ruta 
"./frases/" con un nombre de archivo formado por el tiempo el milisegundos con extensión ".txt"*/
public class Simulacro1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String texto = ("Suelo cocinar algo rico, escuchar música y leer para relajarme antes de salir a caminar, mirar el paisaje y disfrutar el sol que brilla con un táser en el bolsillo.").trim();
		
		System.out.println("Texto original: " + texto);
		
		String regex = "\\b[a-zA-ZñÑ]*[aAeEiIíÍ][rR]\\b";
		
		String nuevoTexto = texto.replaceAll(regex, "(VERBO)");
		
		System.out.println("Texto cambiado: " + nuevoTexto);
		
		boolean exito = escribir(nuevoTexto);
		if(exito) {
			System.out.println("Archivo guardado con éxito.");
		} else {
			System.out.println("ERROR");
		}

	}
	
	public static boolean escribir(String nuevoTexto) {
		Date fecha = new Date();
		try {
			FileWriter fichero = new FileWriter("./frases/" + fecha.getTime() + ".txt", true);
			fichero.write(nuevoTexto);
			fichero.close();
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}

}
