import java.util.LinkedList;
import java.util.Queue;

public class EjemploCola {

	public static void main(String[] args) {
		Queue<String> compra = new LinkedList<String>();
		compra.add("Chocolate");
		compra.add("Galletas");
		compra.add("Pizza");
		listarCompra(compra);
		
		compra.clear();
		
		compra.offer("Tortilla");
		
		listarCompra(compra);
				
	}
	
	public static void listarCompra(Queue<String> lista) {
		//Extraemos la cantidad antes del bucle ya que el size() dara un numero menos
		int cantidad = lista.size();
		for(int i = 0; i < cantidad; i++ ) {
			System.out.println("Articulo : " + lista.poll()); //peek->primero //
		}
	}
	
	
}
