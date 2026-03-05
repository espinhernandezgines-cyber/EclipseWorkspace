import java.util.Scanner;

public class Libros {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Libro[] libros = new Libro[2];
		for(int i=0; i<libros.length; i++) {
			System.out.println(i+1+"º Libro:");
			
			System.out.println("Título: ");
			String titulo = teclado.nextLine();
			System.out.println("Autor: ");
			String autor = teclado.nextLine();
			System.out.println("Número de páginas: ");
			int numDePags = Integer.parseInt(teclado.nextLine());
			
			libros[i] = new Libro(titulo, autor, numDePags);
		}
		
		mostrarInfo(libros);
		teclado.close();
	}

	public static void mostrarInfo(Libro[] libros) {
		System.out.println("\nLIBROS: \n");
		for(int i=0; i<libros.length; i++) {
			System.out.println(i+1 + "º Libro:");
			System.out.println(libros[i].titulo + ", de " + libros[i].autor + ", " + libros[i].numDePags + " páginas");
		}
	}
	
}

class Libro {
	public String titulo;
	public String autor;
	public int numDePags;
	
	public Libro(String titulo, String autor, int numDePags) {
		this.titulo = titulo;
		this.autor = autor;
		this.numDePags = numDePags;
	}
}
