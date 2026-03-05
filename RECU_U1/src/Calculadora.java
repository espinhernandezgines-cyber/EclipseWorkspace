import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		boolean valido = false;
		int opcion = 0;
		
		while(!valido) {
			try {
				System.out.println("----MENU--CALCULADORA----\n"
						+ "1.Sumar"
						+ "\n2.Restar"
						+ "\n3.Multiplicar"
						+ "\n4.Dividir\n"
						+ "\nElige una opción: ");
				opcion = Integer.parseInt(teclado.nextLine());
				if(opcion>=1 && opcion<=4) { valido = true; }
				else { System.out.println("Opción no válida."); }
			} catch (Exception e) { System.out.println("Ingrese opción válida."); }
		}
		
		valido = false;
		double num1 = 0;
		double num2 = 0;
		
		while(!valido) {
			try {
				System.out.println("Introduce el primer número: ");
				num1 = Double.parseDouble(teclado.nextLine());
				System.out.println("Introduce el segundo número: ");
				num2 = Double.parseDouble(teclado.nextLine());
				valido = true;
				if(opcion==1) { System.out.println(num1+num2); }
				if(opcion==2) { System.out.println(num1-num2); }
				if(opcion==3) { System.out.println(num1*num2); }
				if(opcion==4) { System.out.println(num1/num2); }
			} catch(Exception e) { System.out.println("ERROR"); }
		}

		teclado.close();
	}

}
