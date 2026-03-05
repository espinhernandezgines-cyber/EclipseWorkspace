package Ejercicios;

import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Simulacro2 {

	public static void main(String[] args) {
		Date fecha = new Date();
		
		try {
			Scanner teclado = new Scanner(System.in);
			System.out.println("Introduce un domino: ");
			String dominio = teclado.nextLine();
			
			String plantilla = Files.readString(Path.of("./output/plantilla.html"));
		
			Scanner lector = new Scanner(new File("./output/usuarios (1).txt"));
		
			while(lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] datos = linea.split("&");
				
				if(datos[4].endsWith(dominio)) {
					String htmlFinal = plantilla;
					String nombreUsuario = datos[4].split("@")[0];
					
					htmlFinal = htmlFinal.replace("=nombre=", datos[1]);
					htmlFinal = htmlFinal.replace("=apellidos=", datos[2]);
					htmlFinal = htmlFinal.replace("=dni=", datos[3]);
					htmlFinal = htmlFinal.replace("=direccion=", datos[5]);
					htmlFinal = htmlFinal.replace("=telefono=", datos[6]);
					htmlFinal = htmlFinal.replace("=email=", datos[4]);
					
					FileWriter fichero = new FileWriter("./output" + nombreUsuario + fecha.getTime() + ".html", false);
					fichero.write(htmlFinal);
					fichero.close();
					System.out.print("Archivo html generado con éxito.");
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error al buscar el archivo.");
		}
	}

}
