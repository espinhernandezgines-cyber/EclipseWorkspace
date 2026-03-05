import java.util.Scanner;

public class ContarImpares {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numValidos = 0;
		int pares = 0;
		int impares = 0;
		int num = -1;
		
		do {
			try {
				System.out.println("Introduce un número ( 0 para finalizar ) : ");
				num = Integer.parseInt(teclado.nextLine());
				if(num!=0) { numValidos ++; if(num%2 == 0) { pares++; } if(num%2 != 0) { impares++; } }
			} catch (Exception e) { System.out.println("ERROR"); }
			
			if(num==0 && numValidos <2) {
				System.out.println("Al menos 2 números.");
				num = -1;
			}
			
		} while (num!=0);
					
		System.out.println("Has introducido " + numValidos + " numeros, " + pares + " pares, y, "+ impares + " impares.");
		teclado.close();
	}

}
