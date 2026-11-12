
package Utils.Estructurs;

//Sera utilizada para manejar historial de transacciones

import java.util.ArrayList;
import java.util.List;

public class Pila<T> {
    private Nodo<T> cima;
    private int tam;

    public Pila() {
        this.cima = null;
        this.tam = 0;
    }

    public boolean Vacia() {
        return cima == null;
    }

    public void push(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato, cima); // Crea nuevo nodo, envia el tipo de dato 
        //y lo referencia al que es la cima
        cima = nuevoNodo; // Coloca el nuevo nodo como cima
        tam++;
    }

    public T prop() {
        if (Vacia()) {
            return null;
        }
        T dato = cima.getDato(); // Almacenar dato de la cima
        // La cima ahora es el nodo de abajo, los nodos apuntan hacia abajo
        cima = cima.getSiguiente();
        tam--;
        return dato; // Retornar el dato obtenido
    }

    public T Viewtop() {
        if (Vacia()) {
            return null;
        }
        return cima.getDato();
    }

    public int getTam() {
        return tam;
    }

    //Dejar la pila en cero
    public void Limpar() {
        this.cima = null;
        this.tam = 0;
    }
    
    public List<T> aLista() {
        List<T> lista = new ArrayList<>(); //Listta auxiliar para ir desapilando y guardando
        Nodo<T> actual = cima;
        while (actual != null) {
            lista.add(actual.getDato());
            actual = actual.getSiguiente();
        }
        return lista; //Devolver lista
    }
}
