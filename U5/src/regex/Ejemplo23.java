package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplo23 {
	public static void main(String[] args) {
		String texto = "AbC abcdefg abcdefghijklmnopqrstuvwx";
		String regex ="(a|b)+"; //Comprueba si contiene a o b al menos una vez
		
		
		//Hacer búsquedas y extraer los fragmentos que coindicen
		Pattern patron = Pattern.compile(regex);
		Matcher concordancias = patron.matcher(texto);
		
		System.out.println("Concordancias: ");
		while(concordancias.find()) {
			System.out.println("Indice: " + concordancias.start() + " (Valor: " + concordancias.group() + ")");
		}
		
		// Comprobar si toda la cadena cumple con la expresión
		// Que SÍ contenga la @, que no sea al principio ni al final
		boolean res = texto.matches(".*(a|b)+.*");//".*" para que salga true
		System.out.println("Coincide? " + res);
	}
}
