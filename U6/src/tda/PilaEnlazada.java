package tda;

public class PilaEnlazada {
	
	private Nodo primero;
	private int numElementos;
	
	public PilaEnlazada() {
		this.primero = null;
		this.numElementos = 0;
	}
	
	public void clear() {
		this.primero = null;
		this.numElementos = 0;
	}

	public int size() {
		return this.numElementos;
	}
	
	public boolean isEmpty() {
		return this.numElementos == 0;
	}
	
	public void add(Object elem) {
		Nodo nuevo = new Nodo(elem);
		if(this.numElementos == 0) {
			this.primero = nuevo;
		} else {
			Nodo ultimo = obtenerNodo(this.numElementos-1);
			ultimo.siguiente = nuevo;
		}
		this.numElementos++;
	}
	
	private Nodo obtenerNodo(int indice) {
		if(indice < 0 || indice >= this.numElementos) {
			throw new IndexOutOfBoundsException("Indice incorrecto: " + indice);
		}
		Nodo actual = this.primero;
		for(int i = 0; i < indice; i++) {
			actual = actual.siguiente;
		}
		return actual;
	}
	
	public void push(Object elem) {
		Nodo nuevo = new Nodo(elem);
		if(this.numElementos == 0) {
			this.primero = nuevo;
		} else {
			Nodo ultimo = obtenerNodo(this.numElementos-1);
			ultimo.siguiente = nuevo;
		}
		this.numElementos++;
	}
	
	public void add(int indice, Object elem) {
		if(indice < 0 || indice >= this.numElementos) {
			throw new IndexOutOfBoundsException("Indice incorrecto: " + indice);
		}
		if(indice == 0) {
			addPrimero(elem);
		} else {
			Nodo actual = this.primero;
			this.primero = nuevo;
			this.primero.siguiente = actual;
		}
		this.numElementos++;
	}
	
	public void addPrimero(Object elem) {
		Nodo nuevo = new Nodo(elem);
		if(this.numElementos == 0) {
			this.primero = nuevo;
		} else {
			Nodo actual = this.primero;
			this.primero = nuevo;
			this.primero.siguiente = actual;
		}
		this.numElementos++;
	}
	
	public void addIntermedio(int indice, Object elem) {
		Nodo nuevo = new Nodo(elem);
		Nodo anterior = obtenerNodo(indice-1);
		Nodo actual = anterior.siguiente;
		nuevo.siguiente = actual;
		anterior.siguiente = nuevo;
		this.numElementos++;
	}
	
	public int indexOf(Object elem) {
		Nodo actual = this.primero;
		for(int i = 0; actual != null; i++) {
			if((elem == null && actual.dato == null) || actual.dato.equals(elem)) {
				return i;
			}
			actual = actual.siguiente;
		}
		return -1;
	}
	
	public boolean contains(Object elem) {
		return indexOf(elem) != -1;
	}
	
	public Object get(int indice) {
		if(indice < 0 || indice >= this.numElementos) {
			throw new IndexOutOfBoundsException("Indice incorrecto: " + indice);
		}
		Nodo actual = obtenerNodo(indice);
		return actual.dato;
	}
	
	public Object peek() {
		Nodo actual = obtenerNodo(this.numElementos-1);
		return actual.dato;
	}
	
	public Object remove(int indice) {
		if(indice < 0 || indice >= this.numElementos) {
			throw new IndexOutOfBoundsException("Indice incorrecto: " + indice);
		}
		if(indice == 0) {
			return removePrimero();
		}
		
		return removeIntermedio(indice);
	}
	
	private Object removePrimero() {
		Nodo eleminar = this.primero;
		this.primero = this.primero.siguiente;
		this numElementos--;
		return eliminar.dato;
	}
	
	private Object removeIntermedio( int indice) {
		Nodo anterior = obtenerNodo(indice-1);
		Nodo eliminar = obtenerNodo(indice);
		anterior.siguiente = eliminar.siguiente;
		this.numElementos--;
		return eliminar.dato;
	}
	
	public boolean remove(Object elem) {
		int indice = indexOf(elem);
		
		if(indice != -1) {
			remove(indice);
		}
		
		return indice != -1;
	}
	
	public Object pop() {
		if(this.numElementos == 0) {
			throw new IndexOutOfBoundsException("Indice incorrecto");
		} else if(this.numElementos > 1) {
			Nodo penultimo = obtenerNodo(this.numElementos -2);
			Nodo eliminar = penultimo.siguiente;
			penultimo.siguiente = null;
			this.numElementos--;
			return eliminar.dato;
		}
		Nodo eliminar = this.primero;
		this.primero = null;
		this.numElementos--;
		return eliminar.dato;
	}
	
	
}
