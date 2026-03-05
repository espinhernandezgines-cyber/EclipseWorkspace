import java.util.Scanner;

public class Suma8 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int suma = 0;
		
		for (int i=1; i<9 ; i++) {
			System.out.println("Introduce el "+ i + "º  numero: ");
			suma += Integer.parseInt(teclado.nextLine());
		}
		
		System.out.println("La suma total de los 8 números es: " + suma);
		teclado.close();
	}

}
