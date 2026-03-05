package tda;

public class PilaArray {
    /* 
        Hecha por Antonio Molina Amores
        Recreación de un ArrayList hecho en Java
    */
    private Object[] elementos;
    private int cantidadElementos;
    private static final int TAMANO_INICIAL = 4;
    // Constructor: Crea el ArrayList cuando se llama
    public PilaArray(){
        elementos = new Object[TAMANO_INICIAL];
        cantidadElementos = 0;
    }
    // .add(Object element) -> Añade elementos al final del arraylist 
    public void add(Object elemento){  
        if(cantidadElementos == 0){
            elementos[0] = elemento;
            cantidadElementos++;
        }
        else{
            comprobarLlenado();
            elementos[cantidadElementos] = elemento;
            cantidadElementos++;
        }
    } 
    // .push(Object elemento) -> Añade un objeto al final de la pila
    public void push(Object elemento){
        comprobarLlenado();
        elementos[cantidadElementos] = elemento;
        cantidadElementos++;
    }

    // .peek() -> Devuelve el último elemento
    public Object peek(){
        if(cantidadElementos == 0) {
			throw new IndexOutOfBoundsException("Pila vacía...");
		}
        return elementos[cantidadElementos-1];
    }

    // .pop() -> Devuelve el último elementos y lo elimina
    public Object pop(){
        if(cantidadElementos == 0) {
			throw new IndexOutOfBoundsException("Pila vacía...");
		}
        Object objetoADevolver = elementos[cantidadElementos-1];
        elementos[cantidadElementos-1] = null;
        cantidadElementos--;
        comprobarEstrechamiento();
        return objetoADevolver;
    }

    // .add(int index, Object element) -> Añade elementos a en el índice seleccionado 
    public void add(int index, Object elemento){
        if (index >= cantidadElementos || index < 0) {
		    throw new IndexOutOfBoundsException("Índice incorrecto: " + index);
		}

        comprobarLlenado();

        if(index < cantidadElementos){
            for(int i = cantidadElementos-1; i >= index; i--){
                elementos[i+1] = elementos[i];
            }
        }
        elementos[index] = elemento;
        cantidadElementos++;
    }

    // .clear() -> Elimina todos los elementos de la lista
    public void clear(){
        elementos = new Object[TAMANO_INICIAL];
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
        return elementos[index];
    } 

    // .indexOf(Object elemento) -> Devuelve el índice del elemento especificado
    public int indexOf(Object elemento){
        if(elemento == null){
            for(int i = 0; i < cantidadElementos; i++){
                if(elementos[i] == null){
                    return i;
                }
            }
        }
        else{
            for(int i = 0; i < cantidadElementos; i++){
                if(elementos[i].equals(elemento)){
                    return i;
                }
            }
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
        Object objetoADevolver = elementos[index];
        for(int i = index; i < cantidadElementos-1; i++){
            elementos[index] = elementos[index+1];
        }
        elementos[cantidadElementos-1] = null;
        cantidadElementos--;
        comprobarEstrechamiento();
        return objetoADevolver;
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

    // Este método comprueba si el array de elementos está a punto de llenarse
    // En caso de que lo esté duplica el tamaño
    private void comprobarLlenado(){
        if(cantidadElementos+1 == elementos.length){
            Object[] tempArray = new Object[elementos.length*2];
            for(int i = 0; i < elementos.length; i++){
                tempArray[i] = elementos[i];
            }
            elementos = tempArray;
        }
    }

    // Este método se usa cuando se eliminan elementos para ver si se puede reducir el tamaño de la lista
    private void comprobarEstrechamiento(){
        if(elementos.length > TAMANO_INICIAL){
            if(cantidadElementos < (elementos.length/2)){
                Object[] tempArray = new Object[elementos.length/2];
                for(int i = 0; i < cantidadElementos; i++){
                    tempArray[i] = elementos[i];
                }
                elementos = tempArray;
            }
        }
    }
    
}
