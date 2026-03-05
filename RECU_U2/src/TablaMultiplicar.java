import java.util.Scanner;

public class TablaMultiplicar {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		boolean valido = false;
		double num = 0;
		
		while(!valido) {
			try {
				System.out.println("Introduce un número: ");
				num = Double.parseDouble(teclado.nextLine());
				valido = true;
			} catch (Exception e) { System.out.println("ERROR"); }
		}
		
		for(int i=0;i<11;i++) {
			System.out.println(num+" x "+i+" = "+(num*i));
		}
		teclado.close();
	}

}
