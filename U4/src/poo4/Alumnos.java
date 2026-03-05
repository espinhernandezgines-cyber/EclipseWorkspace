//EXAMENNNNNNNNNNN
//EXAMENNNNNNNNNNN
//EXAMENNNNNNNNNNN
package poo4;
import java.util.Scanner;

public class Alumnos {
	private String nombre;
	private String apellido;
	private String dni;
	private String gmail;

	public Alumnos(String nombre, String apellido, String dni, String gmail) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.gmail = gmail;
	}
	
	public void mostrarAlumno() {
		System.out.println(nombre + " " + apellido + " (" + dni + ") Email:" + gmail);
	}
	
	public static Alumnos[] ordenarAlumnos(Alumnos[] alumnos) {
		for(int i = 0; i<alumnos.length; i++) {
			for(int j = i+1; j<alumnos.length; j++) {
				String apellidos1 = alumnos[i].getApellidos();
				String apellidos2 = alumnos[i].getApellidos();
				if(apellidos1.compareToIgnoreCase(apellidos2)>0) {
					Alumnos aux = alumnos[i];
					
				}
			}
		}
		return alumnos;
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int cantidad = 0;
		boolean valido = false;
		do {
			try {
				System.out.println("Introduce la cantidad de alumnos que desee: ");
				cantidad = Integer.parseInt(teclado.nextLine());
				valido = true;
			} catch (Exception e) { System.out.println("Introduce cantidad válida."); }
		} while(!valido);
		
		Alumnos[] alumnos = new Alumnos[cantidad];
		
		for(int i = 0; i<cantidad; i++) {
			System.out.println(i+1 + "º alumno: ");
			
			System.out.print("Nombre: ");
			String nombre = teclado.nextLine();
			System.out.print("Apellido: ");
			String apellido = teclado.nextLine();
			System.out.print("DNI: ");
			String dni = teclado.nextLine();
			System.out.print("gmail: ");
			String gmail = teclado.nextLine();
			
			alumnos[i] = new Alumnos(nombre,apellido,dni,gmail);
		}
		
		System.out.println("Listado de alumnos: ");
		for(int i=0; i<alumnos.length;i++) {
			alumnos[i].mostrarAlumno();
		}
		teclado.close();
	}

}
