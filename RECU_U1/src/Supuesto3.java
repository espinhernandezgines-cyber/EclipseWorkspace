import java.util.Scanner;

public class Supuesto3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		boolean valido = false;
		double num = 0;
		
		while(!valido) {
			try {
				System.out.println("Introduce un número decimal: ");
				num = Double.parseDouble(teclado.nextLine());
				valido = true;
				if(num>=1 && num<=4) { System.out.println("Número con 10% menos de su valor =" + (num-(num*10)/100)); }
				if(num>=5 && num<=10) { System.out.println("Número multiplicado por 2 =" + num*2); }
				if(num>=10 && num<=20) {
					int parteEntera = (int) num; //sacar parte entera de double
					System.out.println("Número con parte entera sumada =" + (num + parteEntera));
				}
				if(num>=25 && num<=30) { System.out.println("Número multiplicado por pi =" + (num * 3.14)); }
				else { System.out.println("Número multiplicado por 10 =" + (num*10)); }
			}catch (Exception e) { System.out.println("ERROR"); }
		}
		teclado.close();
	}

}
