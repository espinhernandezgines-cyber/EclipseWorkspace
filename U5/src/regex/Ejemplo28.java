package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplo28 {
	public static void main(String[] args) {
		
		String regex ="(?i)(<titulo.*?>)(.+?)(</titulo>)";//Extrae texto entre etiquetas
		String texto = "<titulo>EJEMPLO_TEST</titulo>";
		String actualizada= texto.replaceAll(regex, "$2");
		System.out.println("Nuevo original:" + texto);
		System.out.println("Nuevo texto:" + actualizada);
		
	}
}
