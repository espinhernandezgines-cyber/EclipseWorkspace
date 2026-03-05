package tda;

public class pruebaCola {
	
	public static void main(String[] args) {
		ColaArray personas = new ColaArray();
		
		personas.offer("Moira");
		personas.offer("Ginés");
		personas.offer("Yoel");
		personas.offer("Antonio");
		
		System.out.println("¿Quién llegó primero? -> " + personas.peek());
		personas.poll();
		System.out.println("Después de sacar el primero, quedan " + personas.size() + ".\n");
		
		mostrarPersonas(personas);
	}
	
	public static void mostrarPersonas(ColaArray lista) {
		while(lista.size() > 0) {
			System.out.println("Persona: " + lista.poll());
		}
	}

}
