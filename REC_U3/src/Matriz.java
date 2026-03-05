import java.util.Arrays;
import java.util.Scanner;

public class Matriz {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int filas = 0;
		int columnas = 0;
		/*Pedir los valores de las dimensiones de la matriz. 
		 Se debe insistir en caso de que alguna de las dimensiones no sea mayor de 1 
		 (una matriz debe ser como mínimo de 2x2)*/
		do {
			try {
				System.out.println("Introduzca nº de filas de la matriz (>=2): ");
				filas = Integer.parseInt(teclado.nextLine());
				System.out.println("Introduzca nº de columnas de la matriz (>=2): ");
				columnas = Integer.parseInt(teclado.nextLine());
			
				if(filas<2 || columnas<2) { System.out.println("Mínimo 2x2"); }				} catch (Exception e) { System.out.println("ERROR"); }
			} while (filas<2 || columnas<2);
		
		int [][] matriz = generarMatriz(filas, columnas);
		
		for(int i=0; i<matriz.length; i++) {
			System.out.println(Arrays.toString(matriz[i]));
		}
		
		System.out.println();
		
		int [][] matrizT = generarT(filas,columnas, matriz);
		
		for(int i=0; i<matrizT.length; i++) {
			System.out.println(Arrays.toString(matrizT[i]));
		}
			
		teclado.close();
	}
	
	public static int[][] generarMatriz(int f, int c) {
		int[][] matriz = new int[f][c];
		for(int i = 0; i<f; i++) {
			for(int j = 0; j<c; j++) {
				matriz[i][j] = (int)(Math.random()*(9-1+1))+1;
			}
		}
		return matriz;
	}
	
	public static int[][] generarT(int f, int c, int[][] matriz) {
		int [][] matrizT = new int[c][f];
		for(int i = 0; i<f; i++) {
			for(int j = 0; j<c; j++) {
				matrizT [j][i] = matriz[i][j];
			}
		}
		return matrizT;
	}

}
