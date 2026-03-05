package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplo29 {
	public static void main(String[] args) {
		
		String texto = "Me llamo David";
		System.out.println(texto.replaceAll("a..", "AAA"));//Reemplazar cualquier letra a y sus dos siguientes carácteres por AAA
		
	}
}
