import java.util.Scanner;

public class ComprobarEdad {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		boolean valido = false;
		int edad = 0;
		
		while(!valido) {
			try {
				System.out.println("Introduzca su edad: ");
				edad = Integer.parseInt(teclado.nextLine());
				valido = true;
			} catch (Exception e) { System.out.println("ERROR"); }
		}
		
		if(edad>=18 && edad<=130) { System.out.println("Eres mayor de edad."); }
		if(edad<18 && edad>=0) { System.out.println("Eres menor de edad."); }
		else { System.out.println("Introduce edad válida."); }
		
		teclado.close();
	}

}
