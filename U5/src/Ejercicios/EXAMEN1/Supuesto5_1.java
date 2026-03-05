package Ejercicios.EXAMEN1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Supuesto5_1 {

	public static void main(String[] args) {
		Cliente[] misClientes = importarClientes();
		
		if (misClientes != null) {
			mostrarClientes(misClientes);
		}

	}
	
	public static Cliente[] importarClientes() {
		File fichero = new File("./files/clientes (1).txt");
		Scanner lector = null;
		try {
			lector = new Scanner(fichero);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String lineaCompleta = lector.nextLine();
		
		String[] clientes = lineaCompleta.split(";");
		
		Cliente[] cajaVacia = new Cliente[clientes.length];
		
		for(int i = 0; i < cajaVacia.length; i++) {
			String[] datos = clientes[i].split("#");
			
			Cliente c = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7]);
			
			cajaVacia[i] = c;
		}
		
		return cajaVacia;
	}
	
	public static void mostrarClientes(Cliente[] misClientes) {
		for(int i = 0; i < misClientes.length; i++) {
			System.out.println("Cliente nº" + i);
			System.out.println("Nombre: " + misClientes[i].getNombre() + ".");
		}
	}

}
