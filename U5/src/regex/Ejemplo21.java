package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplo21 {
	public static void main(String[] args) {
		String texto = "AbC abcdefg abcdefghijklmnopqrstuvwx";
		String regex ="^[^\\d].*"; // 
		
		
		//Hacer búsquedas y extraer los fragmentos que coindicen
		Pattern patron = Pattern.compile(regex);
		Matcher concordancias = patron.matcher(texto);
		
		System.out.println("Concordancias: ");
		while(concordancias.find()) {
			System.out.println("Indice: " + concordancias.start() + " (Valor: " + concordancias.group() + ")");
		}
		
		// Comprobar si toda la cadena cumple con la expresión
		// Que SÍ contenga la @, que no sea al principio ni al final
		boolean res = texto.matches("^[^\\d].*");
		System.out.println("Coincide? " + res);
	}
}
