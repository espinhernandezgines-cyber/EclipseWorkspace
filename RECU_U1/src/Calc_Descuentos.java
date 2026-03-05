import java.util.Scanner;

public class Calc_Descuentos {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		boolean valido = false;
		double precio = 0;
		double descuento = 0;
		double precio_final = 0;
		
		while (!valido) {
			try {
				System.out.println("Introduce el precio del producto: ");
				precio = Double.parseDouble(teclado.nextLine());
				System.out.println("Introduce el descuento del producto(%): ");
				descuento = Double.parseDouble(teclado.nextLine());
				precio_final = precio - (descuento*precio)/100;
				System.out.println( precio_final);
				valido = true;
			} catch (Exception e) { System.out.println("ERROR"); }
		}
		teclado.close();
	}

}
