package tda;

public final class ColaArray {
	
	// Atributos 
	private Object[] arrayElementos;
	private int numElementos;
	private static final int TAMAÑO_INICIAL = 4;

	// Métodos  
	//Inicializa el array de elementos de la lista.
	public ColaArray() {
	arrayElementos = new Object[TAMAÑO_INICIAL];
	numElementos = 0;
	}
	 
	//@return número de elementos actual en la lista.
	public int size() {
	       return numElementos;
	}
	
	//Añade un elemento a la lista
	//@param elemento - el elemento a añadir
	public void add(Object elemento) {
		if (numElementos == 0) {
			arrayElementos[0] = elemento;
			numElementos++;
		} else {
			comprobarLlenado();
			arrayElementos[numElementos] = elemento;
			numElementos++;
			}
	 }
	
	public void offer(Object elemento) {
		if (numElementos == 0) {
			arrayElementos[0] = elemento;
			numElementos++;
		} else {
			comprobarLlenado();
			arrayElementos[numElementos] = elemento;
			numElementos++;
			}
	 }

	 //Comprueba si el array si el array interno está casi lleno y lo copia
	//ampliando al doble su tamaño.
	      private void comprobarLlenado() {
			// El array interno está casi lleno, se duplica el espacio. 
			if (numElementos + 1 == arrayElementos.length) {
			      Object[] arrayAmpliado = new Object[arrayElementos.length*2];
			    //System.arraycopy(arrayElementos, 0, arrayAmpliado, 0, numElementos);
			      for(int i = 0; i < numElementos; i++) {
			    	  arrayAmpliado[i] = arrayElementos[i];
			      }
				arrayElementos = arrayAmpliado;
			}
		}

		//Inserta un elemento en la posición especificada por el índice.
		//@param indice - indica la posición de inserción en la lista.
		//@param elemento - elemento a insertar.
		//@throws IndexOutOfBoundsException
		public void add(int indice, Object elemento) {
			// El índice debe ser válido.
			if (indice >= numElementos || indice < 0) {
			     throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
			}
			comprobarLlenado();

			// Inserción, desplaza los elementos desde índice indicado.
			if (indice < numElementos) {
				//System.arraycopy(arrayElementos, indice, arrayElementos, indice+1, numElementos - indice);
				for(int i = numElementos-1;i>= indice; i--) {
					arrayElementos[i+1] = arrayElementos[i];
				}
			}
			arrayElementos[indice] = elemento;
			numElementos++;
		}
		
		//Devuelve el índice de la primera ocurrencia para el objeto especificado.
		//@param elem - el elemento buscado.
		//@return el índice del elemento o -1 si no lo encuentra.
		public int indexOf(Object elem) {
			if (elem == null) {
				for (int i = 0; i < numElementos; i++) {
					if (arrayElementos[i] == null) {
						return i;
					}
				}
			} else {
				for (int i = 0; i < arrayElementos.length; i++) {
					if (elem.equals(arrayElementos[i])) {
						return i;
					}
				}
			}
			return -1;
		}
		 
		//Borra todos los elementos de la lista.
		 
		public void clear() {
		    arrayElementos = new Object[TAMAÑO_INICIAL];
		    numElementos = 0;
		}
		
		public boolean isEmpty() {
			return numElementos == 0;
		}
		 
		// Comprueba si existe un elemento.
		//@param elem – el elemento a comprobar.
		//@return true - si existe.
		public boolean contains(Object elem) {
		   return indexOf(elem) != -1; 
		}
		 
		/*Obtiene el elemento-dato por índice.
		 * @param indice - posión relativa del nodo que contiene el elemento-dato.
		 * @return el dato indicado por el índice de nodo; null si está indefinido.
		 *@exception IndexOutOfBoundsException - índice no está entre 0 y numElementos-1.
		 */
		public Object get(int indice) {
		// El índice debe ser válido para la lista.
			if (indice >= numElementos || indice < 0) {
				throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
			}  
				return arrayElementos[indice];
		}
		
		public Object peek() {
			if (numElementos == 0) {
				throw new IndexOutOfBoundsException("La pila está vacía");
			}
			return arrayElementos[0];
		}
		
		public Object poll() {
			if (numElementos == 0) {
				throw new IndexOutOfBoundsException("La pila está vacía");
			}
			Object elem = arrayElementos[0];
			for(int i = 0; i < numElementos; i++) {
				arrayElementos[i] = arrayElementos[i+1];
			}
			arrayElementos[numElementos - 1] = null;
			numElementos--;
			return elem;
		}

		/*
		 * Elimina el elemento especificado en el índice.
		 * @param indice - del elemento a eliminar.
		 * @return - el elemento eliminado.
		* @exception IndexOutOfBoundsException - índice no está entre 0 y numElementos-1.
		 */
		public Object remove(int indice) {
		// El índice debe ser válido para la lista.
			if (indice >= numElementos || indice < 0) {
				throw new IndexOutOfBoundsException("Índice incorrecto: " + indice);
			}
		// Elimina desplazando uno hacia la izquierda, sobre la posición a borrar.
			Object elem = arrayElementos[indice];
		//System.arraycopy(arrayElementos, indice+1, arrayElementos, indice, numElementos - (indice+1));
			for (int i = indice; i < numElementos-1; i++) {
				arrayElementos[i] = arrayElementos[i+1];
			}

		// Ajusta el último elemento.
			arrayElementos[numElementos-1] = null;
			numElementos--;
			return elem;
		}
		 
		/*
		 * Elimina el elemento especificado.
		 * @param elemento - elemento a eliminar.
		 * @return - el índice del elemento eliminado o -1 si no existe.
		 */
		public int remove(Object elem) {
			int indice = indexOf(elem);

			if (indice != -1) {
				remove(indice);
		   	 }		 
			return indice;
		}



}

