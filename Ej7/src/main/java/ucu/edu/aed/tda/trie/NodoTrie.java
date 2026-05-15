package ucu.edu.aed.tda.trie;

import java.io.Serializable;
import java.util.*;

public class NodoTrie<T> implements TNodoTrie<T>, Serializable {

    private Map<Character, NodoTrie<T>> hijos;
    private boolean esPalabra;
    private T dato;

    public NodoTrie() {
        hijos = new HashMap<>();
        esPalabra = false;
        dato = null;
    }

    public Map<Character, NodoTrie<T>> getHijos() {
        return hijos;
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public boolean esPalabra() {
        return esPalabra;
    }

    @Override
    public boolean insertar(String palabra, T dato) {

        NodoTrie<T> nodoActual = this;
        for (char c : palabra.toCharArray()) {
            NodoTrie<T> hijo = nodoActual.hijos.get(c);
            if (hijo == null) {
                hijo = new NodoTrie<>();
                nodoActual.hijos.put(c, hijo);
            }
            nodoActual = hijo;
        }
        nodoActual.esPalabra = true;
        nodoActual.dato = dato;
        return true;
    }

    @Override
    public Entry<T> buscar(String palabra) {
        NodoTrie<T> nodoActual = this;
        for (char c : palabra.toCharArray()) {
            NodoTrie<T> hijo =
                    nodoActual.hijos.get(c);
            if (hijo == null) {
                return null;
            }
            nodoActual = hijo;
        }
        if (nodoActual.esPalabra) {
            return new Entry<>(nodoActual.dato,true,palabra);
        }
        return null;
    }

    @Override
    public List<Entry<T>> predecir(String prefijo) {
        NodoTrie<T> nodoActual = this;
        for (char c : prefijo.toCharArray()) {
            NodoTrie<T> hijo =
                    nodoActual.hijos.get(c);
            if (hijo == null) {
                return new LinkedList<>();
            }
            nodoActual = hijo;
        }
        List<Entry<T>> resultados =new LinkedList<>();
        palabras(nodoActual,prefijo,resultados);
        return resultados;
    }

    private void palabras(NodoTrie<T> nodo, String palabraActual, List<Entry<T>> resultados) {

        if (nodo.esPalabra) {
            resultados.add(new Entry<>(nodo.dato, true, palabraActual));
        }

        for (Map.Entry<Character, NodoTrie<T>> e : nodo.hijos.entrySet()) {
            palabras( e.getValue(), palabraActual + e.getKey(), resultados);
        }
    }

    @Override
    public void recorrer(java.util.function.Consumer<Entry<T>> consumer) {
        List<Entry<T>> lista = predecir("");
        for (Entry<T> e : lista) {
            consumer.accept(e);
        }
    }
}