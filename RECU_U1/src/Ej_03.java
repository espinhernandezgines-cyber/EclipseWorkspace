import java.util.Scanner;

public class Ej_03 {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int num = 0;
		boolean valido = false;
		
		while(!valido) {
			try {
				System.out.println("Introduzca un número: ");
				num = Integer.parseInt(teclado.nextLine());
				valido = true;
			} catch (Exception e) { System.out.println("ERROR"); }
		}
		
		if (num%2 == 0) { System.out.println("El número es par."); }
		if (num%2 != 0) { System.out.println("El número es impar."); }
		
		teclado.close();

	}
}