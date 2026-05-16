package ucu.edu.aed.tda.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class TNodoTrieHashMap<T> implements TNodoTrie<T> {

    private HashMap<Character, TNodoTrieHashMap<T>> hijos;
    private boolean esPalabra;
    private TListaEnlazada<Integer> posiciones;
    private T dato;

    public TNodoTrieHashMap() {
        hijos = new HashMap<>();
        posiciones = new TListaEnlazada<>();
        esPalabra = false;
        dato = null;
    }
    public void insertarSufijo(String palabra, int posicion) {

    TNodoTrieHashMap<T> nodo = this;

    for (char c : palabra.toCharArray()) {

        if (!nodo.hijos.containsKey(c)) {
            nodo.hijos.put(c, new TNodoTrieHashMap<>());
        }

        nodo = nodo.hijos.get(c);

        nodo.posiciones.agregar(posicion);
    }
}
public TListaEnlazada<Integer> buscarPatron(String patron) {

    TNodoTrieHashMap<T> nodo = this;

    for (char c : patron.toCharArray()) {

        if (!nodo.hijos.containsKey(c)) {
            return new TListaEnlazada<>();
        }

        nodo = nodo.hijos.get(c);
    }

    return nodo.posiciones;
}


    @Override
    public boolean insertar(String palabra, T dato) {

        TNodoTrieHashMap<T> nodo = this;

        for (char c : palabra.toCharArray()) {

            if (!nodo.hijos.containsKey(c)) {
                nodo.hijos.put(c, new TNodoTrieHashMap<>());
            }

            nodo = nodo.hijos.get(c);
        }

        if (nodo.esPalabra) {
            return false;
        }

        nodo.esPalabra = true;
        nodo.dato = dato;

        return true;
    }

    @Override
    public Entry<T> buscar(String palabra) {

        TNodoTrieHashMap<T> nodo = this;

        for (char c : palabra.toCharArray()) {

            if (!nodo.hijos.containsKey(c)) {
                return null;
            }

            nodo = nodo.hijos.get(c);
        }

        if (nodo.esPalabra) {
            return new Entry<>(nodo.dato, nodo.esPalabra, palabra);
        }

        return null;
    }

    @Override
    public List<Entry<T>> predecir(String prefijo) {

        List<Entry<T>> resultado = new ArrayList<>();

        TNodoTrieHashMap<T> nodo = this;

        for (char c : prefijo.toCharArray()) {

            if (!nodo.hijos.containsKey(c)) {
                return resultado;
            }

            nodo = nodo.hijos.get(c);
        }

        nodo.predecirRecursivo(prefijo, resultado);

        return resultado;
    }
   
    private void predecirRecursivo(
            String palabraActual,
            List<Entry<T>> resultado) {

        if (this.esPalabra) {
            resultado.add(new Entry<>(dato, esPalabra, palabraActual));
        }

        for (Map.Entry<Character, TNodoTrieHashMap<T>> entry : hijos.entrySet()) {

            char letra = entry.getKey();
            TNodoTrieHashMap<T> hijo = entry.getValue();

            hijo.predecirRecursivo(
                    palabraActual + letra,
                    resultado
            );
        }
    }

    @Override
    public void recorrer(Consumer<Entry<T>> consumer) {
        recorrerRecursivo("", consumer);
    }

    private void recorrerRecursivo(
            String palabraActual,
            Consumer<Entry<T>> consumer) {

        if (esPalabra) {
            consumer.accept(new Entry<>(dato, esPalabra, palabraActual));
        }

        for (Map.Entry<Character, TNodoTrieHashMap<T>> entry : hijos.entrySet()) {

            char letra = entry.getKey();
            TNodoTrieHashMap<T> hijo = entry.getValue();

            hijo.recorrerRecursivo(
                    palabraActual + letra,
                    consumer
            );
        }
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public boolean esPalabra() {
        return esPalabra;
    }
}