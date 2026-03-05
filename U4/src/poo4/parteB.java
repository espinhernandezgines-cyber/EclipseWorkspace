package poo4;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class parteB {

	public static void main(String[] args) {
		ArrayList<Alumnos> alumnos = importarAlumnos();
		alumnos = ordenarAlumnos(alumnos);
	}
	
	public static ArrayList<Alumnos> importarAlumnos() {
		ArrayList<Alumnos> lista = new ArrayList<Alumno>();
		
		try {
			File fichero = new file(./assets/alumnos_poo4.txt);
			Scanner lector = new Scanner(fichero);
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
		}
	}
	
	public static Alumnos[] ordenarAlumnos(Alumnos[] alumnos) {
		for(int i = 0; i<alumnos.size; i++) {
			for(int j = i+1; j<alumnos.size; j++) {
				String apellidos1 = alumnos[i].getApellidos();
				String apellidos2 = alumnos[i].getApellidos();
				if(apellidos1.compareToIgnoreCase(apellidos2)>0) {
					Alumnos aux = alumnos[i];
					alumnos.set(i,alumnos.get(j));
					alumnos.set(j,aux);
					
				}
			}
		}
		return alumnos;
	}

}
	
}
