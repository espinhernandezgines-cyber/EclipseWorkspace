import java.util.Scanner;

public class Persona {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		Personas p1 = new Personas();
		p1.nombre = "Ginés";
		p1.apellidos = "Espín Hernández";
		p1.dni = "21069797A";
		p1.fechaNac = "05/09/2007";

		System.out.println(p1.nombre + " / " + p1.apellidos + " / " + p1.dni + " / " + p1.fechaNac);
		
		teclado.close();
	}
}
	
	class Personas {
		public String nombre;
		public String apellidos;
		public String dni;
		public String fechaNac;
	}


