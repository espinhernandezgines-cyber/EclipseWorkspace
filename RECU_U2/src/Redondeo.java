import java.util.Scanner;

public class Redondeo {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double numero = 0;
		int decimales = 0;
		int factor = 1;
		String opcion;
		
		do {
			System.out.println("Ingresa un número con decimales: ");
			numero = Double.parseDouble(teclado.nextLine());
			System.out.println("Ingresa los decimales que quieres redondear: ");
			decimales = Integer.parseInt(teclado.nextLine());
			
			factor=1;
			for(int i=0; i<decimales; i++) {
				factor *= 10;
			}
			
			double resultado = Math.rint(numero*factor)/factor;
			System.out.println("El número redondeado es: " + resultado);
			System.out.println("Quiere redondear más números?? (s = si)");
			opcion = teclado.nextLine();
		} while (opcion.trim().equalsIgnoreCase("s"));
		
		teclado.close();

	}

}
