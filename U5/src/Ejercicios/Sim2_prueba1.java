package Ejercicios;

import java.util.Date;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;
import java.io.FileWriter;

public class Sim2_prueba1 {

	public static void main(String[] args) {
		Date fecha = new Date();
		
		try {
			Scanner teclado = new Scanner(System.in);
			System.out.println("Introduce un dominio: ");
			String dominio = teclado.nextLine();
			String plantilla = Files.readString(Path.of("./output/plantilla.html"));
			
			Scanner lector = new Scanner(new File("./output/usuarios (1).txt"));
			
			while(lector.hasNextLine()) {
				String linea = lector.nextLine();
				if (linea.trim().isEmpty()) continue;//Por si da error al tener linea vacia
				String[] dato = linea.split("&");
				
				if(dato[4].endsWith(dominio)) {
					String html = plantilla;
					String nomU = dato[4].split("@")[0];
					
					html = html.replace("=nombre=", dato[1]);
					html = html.replace("=apellidos=", dato[2]);
					html = html.replace("=dni=", dato[3]);
					html = html.replace("=direccion=", dato[5]);
					html = html.replace("=telefono=", dato[6]);
					html = html.replace("=email=", dato[4]);
					
					FileWriter fichero = new FileWriter("./output/" + fecha.getTime() + "_" + nomU + ".html", false);
					fichero.write(html);
					fichero.close();
					System.out.println("Archivo generado con éxito.");
					
				}
			}
			
		} catch(Exception e) { System.out.print("ERROR"); }
	}

}
