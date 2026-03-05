import java.util.ArrayList;

public class EjemploLista1 {

	public static void main(String[] args) {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("Ginés", "Espín Hernández"));
		
		mostrarPersonas(personas);
		
		System.out.println("Está vacía la lista?" + personas.isEmpty());
		
		System.out.println("Elemino el segundo elemento y muestro la lista de nuevo.");
		
		Persona eliminado = personas.remove(1);
		
		System.out.println("Persona eliminada: " + eliminado.getNombre() + eliminado.getApellidos());
		
		mostrarPersonas(personas);

	}
	
	public static void mostrarPersonas(ArrayList<Persona> lista) {
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("Persona " + (i+1));
			System.out.println("Nombre completo: " + lista.get(i).getNombre() + " " + lista.get(i).getApellidos());
		}
	}

}
