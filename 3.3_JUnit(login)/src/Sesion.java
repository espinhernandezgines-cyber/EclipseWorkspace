import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sesion {
	
	public boolean login(String usuario, String password) {
		File archivo = new File("./assets/usuarios.txt");//Ruta del txt
		Scanner lector = null; //Declaro lector null para cerrarlo luego
		
		try {
			lector = new Scanner(archivo);
			
			while(lector.hasNextLine()) { //Mientras halla lineas pa leer
				String linea = lector.nextLine();
				String[] partes = linea.split("#");
				
				if(partes.length >=2) {
					String userFile = partes[0].trim();//Guardar user de file en pos 0 de String[]
					String passFile = partes[1].trim();//""
					
					if(userFile.equals(usuario) && passFile.equals(password)) {
						lector.close();
						return true;
					}
				}
			}
			
			lector.close();
			return false;
			
		} catch(FileNotFoundException e) {
			System.out.println("No se encontró el archivo.");
			return false;
		}
	}
}
