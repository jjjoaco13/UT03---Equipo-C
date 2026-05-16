package ucu.edu.aed.tda.trie;

public class TNodo<T> {
    private T dato;
    TNodo<T> siguiente;

    public TNodo(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public TNodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(TNodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}
