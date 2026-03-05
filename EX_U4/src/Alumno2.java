import java.io.*;
import java.util.Scanner;

public class Alumno2 {

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
		
		for (int i = 0; i < alumnos.length - 1; i++) {
		    for (int j = i + 1; j < alumnos.length; j++) {
		       
		        if (alumnos[i].getApellidos().compareToIgnoreCase(alumnos[j].getApellidos()) > 0) {
		            
		            Alumno temp = alumnos[i];
		            alumnos[i] = alumnos[j];
		            alumnos[j] = temp;
		        }
		    }
		}
		
		System.out.println("\nLISTADO DE ALUMNOS: ");
		for(int i=0; i<alumnos.length; i++) {
			System.out.println(alumnos[i].info() + "\n");
		}
		
		 try {
			 File archivo = new File("ListadoAlu.html");
			 FileWriter fw = new FileWriter(archivo);
			    
	            fw.write("<!DOCTYPE html>\n");
	            fw.write("<html lang='es'>\n");
	            fw.write("<head>\n");
	            fw.write("<meta charset='UTF-8'>\n");
	            fw.write("<title>Listado de Alumnos</title>\n");
	            fw.write("<style>table, th, td { border: 1px solid black; border-collapse: collapse; padding:5px; }</style>\n");
	            fw.write("</head>\n");
	            fw.write("<body>\n");
	            fw.write("<h2>Listado de Alumnos</h2>\n");
	            fw.write("<table>\n");
	            fw.write("<tr><th>Nombre</th><th>Apellidos</th><th>Gmail</th><th>Dirección</th></tr>\n");

	            for (int i = 0; i < alumnos.length; i++) {
	                fw.write("<tr>");
	                fw.write("<td>" + alumnos[i].getNombre() + "</td>");
	                fw.write("<td>" + alumnos[i].getApellidos() + "</td>");
	                fw.write("<td>" + alumnos[i].getGmail() + "</td>");
	                fw.write("<td>" + alumnos[i].getDireccion() + "</td>");
	                fw.write("</tr>\n");
	            }

	            fw.write("</table>\n");
	            fw.write("</body>\n");
	            fw.write("</html>");
	            fw.close();

	            System.out.println("Archivo HTML generado correctamente: ListadoAlu.html");

	        } catch (IOException e) {
	            System.out.println("Error al crear el archivo HTML: ");
	        }
		System.out.println("Fin de programa.");
		teclado.close();
	}
}
