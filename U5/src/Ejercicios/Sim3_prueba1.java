package Ejercicios;
import java.util.Scanner;

public class Sim3_prueba1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduze una dirección IP: ");
		String ip = teclado.nextLine();
		
		String regex = "^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|(0|[1-9]))\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|(0|[1-9]))$";
		
		if (ip.matches(regex)) {
			System.out.println("IP válido.");
		} else {
			System.out.println("IP no válido.");
		}
		teclado.close();
	}

}
