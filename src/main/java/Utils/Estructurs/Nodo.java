package Utils.Estructurs;

/*
 * Nodo genérico para estructuras de datos enlazadas.
 * @param <T> Tipo de dato que almacenará el nodo.
 */
public class Nodo<T> {
    private T dato; //T convierte el tipo de dato en un dato generico
    private Nodo<T> siguiente;

    public Nodo(T dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
