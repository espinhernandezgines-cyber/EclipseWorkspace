import java.util.Scanner;

public class ComprobarTexto {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String texto = "";
		
		System.out.println("Introduce la contraseña: ");
		texto = teclado.nextLine();
		if(texto.trim().equalsIgnoreCase("ayuwoki")) {
			System.out.println("OLÉÉ");
		}
		else {
			System.out.println("Susto.");
		}
		teclado.close();

	}

}
