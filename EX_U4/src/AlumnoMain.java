import java.util.Scanner;

public class AlumnoMain {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Inicio del programa.\n");
		System.out.println("Selecciona cantidad de alumnos a crear:");
		int cantidad = Integer.parseInt(teclado.nextLine());
		
		Alumno[] alumnos = new Alumno[cantidad];
		
		for(int i = 0; i<alumnos.length; i++) {
			System.out.println(i+1+"º alumno:\n");
			alumnos[i] = new Alumno();
			System.out.println("Nombre: ");
			alumnos[i].setNombre(teclado.nextLine());
			System.out.println("Apellidos: ");
			alumnos[i].setApellidos(teclado.nextLine());
			System.out.println("Gmail: ");
			alumnos[i].setGmail(teclado.nextLine());
			System.out.println("Dirección: ");
			alumnos[i].setDireccion(teclado.nextLine());
		}
		
		System.out.println("\nLISTADO DE ALUMNOS: ");
		for(int i=0; i<alumnos.length; i++) {
			System.out.println(alumnos[i].info() + "\n");
		}
		
		int opcion = 0;
		boolean valido = false;
		do {
			System.out.println("Desea ver la info de un alumno en concreto?");
			System.out.println("\n-----MENÚ-----\n");
				for(int i= 0; i<alumnos.length;i++) {
					System.out.println("Opcion-"+ (i+1)+". "+alumnos[i].getNombre());
				} System.out.println("Opción-0. Salir");
			try {
				System.out.println("Ingrese una opción: ");
				opcion = Integer.parseInt(teclado.nextLine());
					
					if(opcion>=1 && opcion <= alumnos.length) {
						valido = true;
						System.out.println("INFO: ");
						System.out.println(alumnos[opcion-1].info());
					} else if (opcion == 0) {
						System.out.println("Saliendo...");
						break;
					}else { System.out.println("Ingrese opción válida!"); }
			
			} catch(Exception e) {System.out.println("Ingrese opción válida!"); }
		}while(!valido || opcion !=0);
		
		System.out.println("\nFin del programa.");
		teclado.close();
	}

}
