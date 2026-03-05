import java.util.Scanner;

public class Triangulos {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int A = 0;
		int B = 0;
		int C = 0;
		boolean valido = false;
		do {
			try {
				System.out.println("Introduce lado A del triángulo: ");
				A = Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce lado B del triángulo: ");
				B = Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce lado C del triángulo: ");
				C = Integer.parseInt(teclado.nextLine());
				
				if (A+B<C || A+C<B || B+C<A) {
					System.out.println("\nIntroduce tamaños válidos.\n");
				} else { valido = true; }
			} catch (Exception e) { System.out.println("NO VÁLIDO!"); }
		} while (!valido);
		
		if(A==B && B==C) { System.out.println("EQUILÁTERO:"); }
		else if(A==B || A==C || B==C) { System.out.println("ISÓSCELES:"); }
		else { System.out.println("ESCALENO:\n"); }
		
		String triangulo = generarTriangulo(A,B,C);
		System.out.println(triangulo);
		teclado.close();
	}

	public static String generarTriangulo(int A, int B, int C) {
		String texto= "";
		int lado = A;
		if(B>A && B>C) { lado = B; }
		if(C>A && C>B) { lado = C; }
		for(int i = 0; i<=lado ; i++) {
			for(int j = 0; j<i; j++) {
				texto += "* ";
			}
			texto += "\n";
		}
		
		return texto;
	}
}
