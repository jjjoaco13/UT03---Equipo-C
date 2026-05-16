package ucu.edu.aed.tda.trie;

import java.util.Comparator;
import java.util.function.Predicate;

public class TListaEnlazada<T> implements TDALista<T> {
    private TNodo<T> primero;
    private int tamaño;

    @Override
    public void agregar(T elem) {
        TNodo<T> nuevoNodo = new TNodo<>(elem);
        if (primero == null) {
            primero = nuevoNodo;
        } else {
            TNodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        tamaño++;
    }

    @Override
    public void agregar(int index, T elem) {
        if (index < 0 || index > tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        TNodo<T> nuevoNodo = new TNodo<>(elem);
        if (index == 0) {
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
        } else {
            TNodo<T> actual = primero;
            for (int i = 0; i < index - 1; i++) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
        tamaño++;
    }

    @Override
    public T obtener(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        TNodo<T> actual = primero;
        for (int i = 0; i < index; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    @Override
    public T remover(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        TNodo<T> actual = primero;
        if (index == 0) {
            primero = primero.getSiguiente();
        } else {
            for (int i = 0; i < index - 1; i++) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
        }
        tamaño--;
        return actual.getDato();
    }

    @Override
    public boolean remover(Object elem) {
        TNodo<T> actual = primero;
        TNodo<T> anterior = null;
        while (actual != null) {
            if (actual.getDato().equals(elem)) {
                if (anterior == null) {
                    primero = actual.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                tamaño--;
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public boolean contiene(T elem) {
        TNodo<T> actual = primero;
        while (actual != null) {
            if (actual.getDato().equals(elem)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;        
    }

    @Override
    public int indiceDe(Object elem) {
        TNodo<T> actual = primero;
        int index = 0;
        while (actual != null) {
            if (actual.getDato().equals(elem)) {
                return index;
            }
            actual = actual.getSiguiente();
            index++;
        }
        return -1;
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        TNodo<T> actual = primero;
        while (actual != null) {
            if (criterio.test(actual.getDato())) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        TDALista<T> listaOrdenada = new TListaEnlazada<>();
        TNodo<T> actual = primero;
        while (actual != null) {
            T dato = actual.getDato();
            int index = 0;
            while (index < listaOrdenada.tamaño() && comparator.compare(dato, listaOrdenada.obtener(index)) > 0) {
                index++;
            }
            listaOrdenada.agregar(index, dato);
            actual = actual.getSiguiente();
        }
        return listaOrdenada;
    }

    @Override
    public int tamaño() {
        return tamaño;
    }

    @Override
    public boolean esVacio() {
        return tamaño == 0;
    }

    @Override
    public void vaciar() {
        primero = null;
        tamaño = 0;
    }
    @Override
public String toString() {

    StringBuilder sb = new StringBuilder();

    sb.append("[");

    TNodo<T> actual = primero;

    while (actual != null) {

        sb.append(actual.getDato());

        if (actual.siguiente != null) {
            sb.append(", ");
        }

        actual = actual.siguiente;
    }

    sb.append("]");

    return sb.toString();
}
    
}
