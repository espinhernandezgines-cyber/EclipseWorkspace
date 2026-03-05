package tda;

public class pruebaPila {

	public static void main(String[] args) {
		PilaArray gente = new PilaArray();
		gente.push("Pepe");
		gente.push("Antonio");
		gente.push("Carlos");
		gente.push("María");
		
		gente.add(2, "Moira");
		
		System.out.println("¿Quién está en la cima de la pila?: " + gente.peek());
		
		mostrarGente(gente);
		
	}
	
	public static void mostrarGente(PilaArray lista) {
		while(lista.size() > 0) {
			System.out.println("Persona: " + lista.pop());
		}
			
	}

}
