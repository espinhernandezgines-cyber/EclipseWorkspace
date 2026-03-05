package tda;

public class ColaEnlazada {
    /* 
        Hecha por Antonio Molina Amores
        Recreación de un ArrayList hecho en Java
    */
    private Nodo primerElemento;
    private int cantidadElementos;
    
    // Constructor: Crea el ArrayList cuando se llama
    public ColaEnlazada(){
        primerElemento = null;
        cantidadElementos = 0;
    }
    private Nodo obtenerNodo(int index){
        Nodo temp = primerElemento;
        for(int i = 0; i < index; i++){
            temp = temp.siguiente;
        }
        return temp;
    }

    // .offer() -> Añade un elemento al final de cola
    public void offer(Object elemento){

        if(cantidadElementos == 0){
            primerElemento = new Nodo(elemento);
        }
        else{
            Nodo actual = obtenerNodo(cantidadElementos-1);
            actual.siguiente = new Nodo(elemento);
        }
        cantidadElementos++;
    }


    // .poll() -> Extrae el primer elemento de la cola
    public Object poll(){
        if(cantidadElementos == 0){
            throw new IndexOutOfBoundsException("Cola vacia...");
        }
        Nodo primero = primerElemento;
        primerElemento = primerElemento.siguiente;
        cantidadElementos--;
        return primero.dato;
    }


    // .peek() -> Devuelve el primer elemento
    public Object peek(){
        if(cantidadElementos == 0) {
			throw new IndexOutOfBoundsException("Pila vacía...");
		}
        return primerElemento.dato;
    }


    // .add(int index, Object element) -> Añade elementos a en el índice seleccionado 
    public void add(int index, Object elemento){
        if (index >= cantidadElementos || index < 0) {
		    throw new IndexOutOfBoundsException("Índice incorrecto: " + index);
		}
        if(index == 0){
            insertarPrimero(elemento);
        }
        else{
            insertarIntermedio(elemento, index);
        }
        cantidadElementos++;
    }

    private void insertarPrimero(Object elemento){
        if(cantidadElementos == 0){
            primerElemento = new Nodo(elemento);
        }
        else{
            Nodo nuevoPrimero = new Nodo(elemento);
            nuevoPrimero.siguiente = primerElemento;
            primerElemento = nuevoPrimero;
        }
    }
    private void insertarIntermedio(Object elemento, int index){
        Nodo anterior = obtenerNodo(index-1);
        Nodo siguiente = anterior.siguiente;
        Nodo insertar = new Nodo(elemento);
        insertar.siguiente = siguiente;
        anterior.siguiente = insertar;
    }


    // .clear() -> Elimina todos los elementos de la lista
    public void clear(){
        primerElemento = null;
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
        int i = 0;
        while(actual.siguiente != null){
            if(elemento == null && actual.dato == null){
                return i;
            }
            else if(actual.dato.equals(elemento)){
                return i;
            }
            i++;
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
        return quitarIntermedio(index);
    }

    private Object quitarPrimero(){
        Nodo actualPrimero = primerElemento;
        primerElemento = actualPrimero.siguiente;
        cantidadElementos--;
        return actualPrimero.dato;
    }
    private Object quitarIntermedio(int index){
        Nodo anterior = obtenerNodo(index-1);
        Nodo remover = anterior.siguiente;
        if(remover.siguiente != null){
            Nodo siguiente = remover.siguiente;
            anterior.siguiente = siguiente;
        }
        else{
            anterior.siguiente = null;
        }
        cantidadElementos--;
        return remover.dato; 
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
