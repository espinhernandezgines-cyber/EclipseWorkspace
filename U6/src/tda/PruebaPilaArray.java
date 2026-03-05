package tda;

public class PruebaPilaArray {
	public static void main(String[] args) {
		
		PilaArray gente = new PilaArray();
		gente.push("A");
		gente.push("M");
		gente.push("D");
		gente.push("K");
		
		System.out.println("Quién está encima de la pila? " + gente.peek());
		
		mostrarGente(gente);

	}

	private static void mostrarGente(PilaArray gente) {
		while(gente.size() > 0) {
			System.out.println("Persona: " + gente.pop());
		}
		
	}

}
