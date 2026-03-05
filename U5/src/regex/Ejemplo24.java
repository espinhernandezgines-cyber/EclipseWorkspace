package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplo24 {
	public static void main(String[] args) {
		String texto = "ginesespinhernandez@gmail.com";
		String regex ="^[\\w-\\+]+(\\[\\w-\\+]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; //Correos
		
		
		//Hacer búsquedas y extraer los fragmentos que coindicen
		Pattern patron = Pattern.compile(regex);
		Matcher concordancias = patron.matcher(texto);
		
		System.out.println("Concordancias: ");
		while(concordancias.find()) {
			System.out.println("Indice: " + concordancias.start() + " (Valor: " + concordancias.group() + ")");
		}
		
		// Comprobar si toda la cadena cumple con la expresión
		// Que SÍ contenga la @, que no sea al principio ni al final
		boolean res = texto.matches("^[\\w-\\+]+(\\.[\\w-\\+]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		System.out.println("Coincide? " + res);
	}
}
