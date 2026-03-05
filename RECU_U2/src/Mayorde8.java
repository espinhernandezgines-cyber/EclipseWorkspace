import java.util.Scanner;

public class Mayorde8 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int mayor = 0;
		int numero;
		boolean primero = true;
		String opcion;
		
		do {
			System.out.println("Introduce un número: ");
			numero = Integer.parseInt(teclado.nextLine());
			
			if (primero = true) {
				mayor = numero;
				primero = false;
			}
			if (numero>mayor) {
				numero = mayor;
			}
			
			System.out.println("Quiere introducir más números??(s = sí)");
			opcion = teclado.nextLine();
			} while (opcion.trim().equalsIgnoreCase("s"));
		
		System.out.println("El mayor número introducido es: "+ mayor);
		teclado.close();
	}

}
