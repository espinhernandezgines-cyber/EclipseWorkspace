package tda;

public class PilaEnlazada {
    /* 
        Hecha por Antonio Molina Amores
        Recreación de un ArrayList hecho en Java
    */
    private Nodo primerElemento;
    private int cantidadElementos;
    // Constructor: Crea el ArrayList cuando se llama
    public PilaEnlazada(){
        primerElemento = null;
        cantidadElementos = 0;
    }
    // .add(Object element) -> Añade elementos al final del arraylist 
    public void add(Object elemento){
        Nodo elementoNodo = new Nodo(elemento);  
        Nodo ultimo = null;
        if(cantidadElementos == 0){
            primerElemento = elementoNodo;
            cantidadElementos++;
        }
        else{
            ultimo = obtenerNodo(cantidadElementos-1);
            ultimo.siguiente = elementoNodo;
        }
        cantidadElementos++;
    } 


    private Nodo obtenerNodo(int index){
        if(index >= cantidadElementos || index < 0){
            throw new IndexOutOfBoundsException("Indice incorrecto: " + index);
        }
        Nodo actual = primerElemento;
        for(int i = 0; i < index; i++){
            actual = actual.siguiente;
        }
        return actual;
    }

    // .push(Object elemento) -> Añade un objeto al final de la pila
    public void push(Object elemento){
        Nodo ultimo = obtenerNodo(cantidadElementos-1);
        ultimo.siguiente = new Nodo(elemento);
        cantidadElementos++;
    }

    // .peek() -> Devuelve el último elemento
    public Object peek(){
        if(cantidadElementos == 0) {
			throw new IndexOutOfBoundsException("Pila vacía...");
		}
        return obtenerNodo(cantidadElementos-1).dato;
    }

    // .pop() -> Devuelve el último elementos y lo elimina
    public Object pop(){
        if(cantidadElementos == 0) {
			throw new IndexOutOfBoundsException("Pila vacía...");
		}

        if(cantidadElementos > 1){
            Nodo penultimo = obtenerNodo(cantidadElementos-2);
            Nodo devolver = penultimo.siguiente;
            penultimo.siguiente = null;
            cantidadElementos--;
            return devolver;
        }
        Nodo devolver = primerElemento;
        primerElemento = null;
        cantidadElementos = 0;
        return devolver;
    }

    // .add(int index, Object element) -> Añade elementos a en el índice seleccionado 
    public void add(int index, Object elemento){
        if (index >= cantidadElementos || index < 0) {
		    throw new IndexOutOfBoundsException("Índice incorrecto: " + index);
		}

        if(index == 0){
            anadirPrimero(elemento);
        }
        else{
            anadirIntermedio(index, elemento);
        }
        cantidadElementos++;
    }

    private void anadirPrimero(Object elemento){
        Nodo nuevo = new Nodo(elemento);
        if(cantidadElementos==0){
            primerElemento = nuevo;
        }
        else{
            Nodo original = primerElemento;
            primerElemento = nuevo;
            primerElemento.siguiente = original;
        }
        cantidadElementos++;
    }

    private void anadirIntermedio(int index, Object elemento){
        Nodo nuevo = new Nodo(elemento);
        Nodo anterior = obtenerNodo(index-1);
        Nodo desplazar = anterior.siguiente;
        nuevo.siguiente = desplazar;
        anterior.siguiente = nuevo;
        cantidadElementos++;
    }

    // .clear() -> Elimina todos los elementos de la lista
    public void clear(){
        primerElemento = null;;
        cantidadElementos = 0;
    }
    // .contains(Object elemento) -> Comprueba si el elemento indicado está en la lista o no
    public boolean contains(Object elemento){
        return indexOf(elemento) != -1;
    }

    // .get(int index) -> Devuelve el elemento que está en el índice especificado
    public Object get(int index){
        if (index >= cantidadElementos || index < 0) {
		    throw new IndexOutOfBoundsException("Índice incorrecto: " + index);
		}
        return obtenerNodo(index).dato;
    } 

    // .indexOf(Object elemento) -> Devuelve el índice del elemento especificado
    public int indexOf(Object elemento){
        Nodo actual = primerElemento;
        for(int i = 0; actual != null; i++){
            if((elemento != null && actual.dato == null) || (actual.dato.equals(elemento))){
                return i;
            }
            actual = actual.siguiente;
        }
        return -1;
    }

    // .isEmpty() -> Comprueba si la lista contiene algun elemento
    public boolean isEmpty(){
        if(cantidadElementos == 0){
            return true;
        }
        return false;
    }

    // .remove(int index) -> Elimina el objeto del índice especificado
    public Object remove(int index){
        if(index < 0 || index >= cantidadElementos){
            throw new IndexOutOfBoundsException("Índice incorrecto: " + index);
        }
        if(index == 0){
            return quitarPrimero();
        }
        else{
            return quitarIntermedio(index);
        }
    }

    private Object quitarPrimero(){
        primerElemento = primerElemento.siguiente;
        cantidadElementos--;
        return primerElemento.dato;
    }

    private Object quitarIntermedio(int index){
        Nodo anterior = obtenerNodo(index-1);
        Nodo actual = anterior.siguiente;
        anterior.siguiente = actual.siguiente;
        cantidadElementos--;
        return actual.dato;
    }

    // .remove(Object elemento) -> Elimina el objeto del índice especificado
    public int remove(Object elemento){
        int indice = indexOf(elemento);
        if(indice != -1){
            remove(indice);
        }
        return indice;
    }

    // .size() -> Devuelve el tamaño de la lista
    public int size(){
        return cantidadElementos;
    }
    
}
