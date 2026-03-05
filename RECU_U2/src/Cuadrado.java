import java.util.Scanner;

public class Cuadrado {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el tamaño del lado del cuadrado: ");
		int lado = Integer.parseInt(teclado.nextLine());
		
		for(int i =0; i<lado; i++) { //bucle filas
			for(int j=0; j<lado; j++) { //bucle columnas
				if(i==0||i==lado-1||j==0||j==lado-1) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println(); //salto de line en cada fila
		}
		teclado.close();

	}

}
