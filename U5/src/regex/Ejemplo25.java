package regex;//NO VAAAA

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplo25 {
	public static void main(String[] args) {
		String texto = "Prueba#8x";
		String regex ="(?=.*[A-ZÑ])(?=.*[a-zñ])(?=.*\\d)(?=.+[$*-+&!?%]).{8,16}"; //Contraseña(1Letra mayus, 1Minus, 1Numerico, Caracter especial($*-+&!?%))
		
		
		//Hacer búsquedas y extraer los fragmentos que coindicen
		Pattern patron = Pattern.compile(regex);
		Matcher concordancias = patron.matcher(texto);
		
		System.out.println("Concordancias: ");
		while(concordancias.find()) {
			System.out.println("Indice: " + concordancias.start() + " (Valor: " + concordancias.group() + ")");
		}
		
		// Comprobar si toda la cadena cumple con la expresión
		// Que SÍ contenga la @, que no sea al principio ni al final
		boolean res = texto.matches("(?=.*[A-ZÑ])(?=.*[a-zñ])(?=.*\\d)(?=.+[$*-+&!?%]).{8,16}");
		System.out.println("Coincide? " + res);
	}
}
