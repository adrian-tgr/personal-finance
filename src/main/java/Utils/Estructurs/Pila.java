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

    public T pop() {
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
    // 1. Obtener la transacción de una fila específica sin alterar el orden de la pila

    public T obtenerPorIndice(int indiceObjetivo) {
        if (Vacia() || indiceObjetivo < 0 || indiceObjetivo >= tam) {
            return null;
        }

        Pila<T> pilaAuxiliar = new Pila<>();
        T encontrado = null;
        int indiceActual = 0;

        // Desapilar hasta llegar a la profundidad deseada
        while (!Vacia()) {
            T elemento = pop();
            pilaAuxiliar.push(elemento);
            if (indiceActual == indiceObjetivo) {
                encontrado = elemento;
                break;
            }
            indiceActual++;
        }

        // Devolver todo a la pila original en su mismo orden LIFO
        while (!pilaAuxiliar.Vacia()) {
            push(pilaAuxiliar.pop());
        }

        return encontrado;
    }

// Eliminar una transacción específica desapilando en una auxiliar y re-apilando rápido
    public boolean eliminarPorIndice(int indiceObjetivo) {
        if (Vacia() || indiceObjetivo < 0 || indiceObjetivo >= tam) {
            return false;
        }

        Pila<T> pilaAuxiliar = new Pila<>();
        int indiceActual = 0;
        boolean eliminado = false;

        // Desapilar rápido solo hasta llegar a la fila seleccionada
        while (!Vacia()) {
            T elemento = pop();
            if (indiceActual == indiceObjetivo) {
                eliminado = true;
                break;
            } else {
                pilaAuxiliar.push(elemento);
                indiceActual++;
            }
        }

        // Volver a apilar los elementos superiores en su orden original
        while (!pilaAuxiliar.Vacia()) {
            push(pilaAuxiliar.pop());
        }

        return eliminado;
    }

    public boolean actualizarPorIndice(int indiceObjetivo, T nuevoDato) {
        if (Vacia() || indiceObjetivo < 0 || indiceObjetivo >= tam) {
            return false;
        }

        Pila<T> pilaAuxiliar = new Pila<>();
        int indiceActual = 0;
        boolean actualizado = false;

        while (!Vacia()) {
            T elemento = pop();
            if (indiceActual == indiceObjetivo) {
                pilaAuxiliar.push(nuevoDato); // Reemplazar el nodo editado
                actualizado = true;
                break;
            } else {
                pilaAuxiliar.push(elemento);
                indiceActual++;
            }
        }

        while (!pilaAuxiliar.Vacia()) {
            push(pilaAuxiliar.pop());
        }

        return actualizado;
    }
}
