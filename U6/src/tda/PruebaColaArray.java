package tda;

public class PruebaColaArray {
	
	public static void main(String[] args) {
		ColaArray personas = new ColaArray();
		
		
		personas.offer("Moira");
		personas.offer("Ginés");
		personas.offer("Yoel");
		personas.offer("Antonio");
		
		System.out.println("Quién llegó primero? " + personas.peek());
		personas.poll();
		System.out.println("Después de sacar el primero, quedan: " + personas.size());
		
		mostrarPersonas(personas);
	}
	
	private static void mostrarPersonas(ColaArray personas) {
		while(personas.size() > 0) {
			System.out.println("Persona: " + personas.poll());
		}
		
	}
}
