import java.util.Scanner;

public class Ej_02 {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		boolean valido = false;
		
		while(!valido) {
			try {
				System.out.println("Introduce el primer número: ");
				num1 = Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce el segundo número: ");
				num2 = Integer.parseInt(teclado.nextLine());
				valido = true;
			} catch(Exception e) {
				System.out.println("ERROR: Introduzca numeros naturales.");
			}
		}
		
		if(num1 > num2) { System.out.println(num1 + " es mayor que " + num2); }
		if(num2 > num1) { System.out.println(num2 + " es mayor que " + num1); }
		if(num2 == num1) { System.out.println("Iguales."); }

		teclado.close();

	}
}
