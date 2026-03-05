import java.util.Scanner;

public class Ej_01 {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		boolean valido = false;
		while (!valido) {
			try {
				System.out.println("Escriba el nombre de la primera persona: ");
				String name1 = teclado.nextLine();
				System.out.println("Escribe la edad de la primera persona: ");
				int age1 = Integer.parseInt(teclado.nextLine());
				System.out.println("Escriba el nombre de la segunda persona: ");
				String name2 = teclado.nextLine();
				System.out.println("Escribe la edad de la segunda persona: ");
				int age2 = Integer.parseInt(teclado.nextLine());
				valido = true;
	
				System.out.println(name1 + ", " + age1 + ".");
				System.out.println(name2 + ", " + age2 + ".");
			} catch (Exception e) {
				System.out.println("ERROR: Ingrese valores adecuados.");
			}
		}
		teclado.close();
	}
}
