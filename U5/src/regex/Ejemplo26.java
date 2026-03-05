package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplo26 {
	public static void main(String[] args) {
		
		String regex ="(\\w)(\\s+)([\\.,])";
		String texto = "Hola , Esto esta regular .";
		System.out.println(texto);
		System.out.println(texto.replaceAll(regex, "$1$3"));//Elimina espacios en blanco mal puestos
		
	}
}
