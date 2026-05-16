package ucu.edu.aed.tda.trie;

import java.util.List;
import java.util.function.Consumer;

public class TtrieHashMap<T> {

private TNodoTrieHashMap<T> raiz;
public TtrieHashMap() {
    raiz = new TNodoTrieHashMap<>();
}
public boolean insertar(String palabra, T dato) {
    return raiz.insertar(palabra, dato);
}
public Entry<T> buscar(String palabra) {
    return raiz.buscar(palabra);
}
public void insertarSufijos(String texto) {

    for (int i = 0; i < texto.length(); i++) {

        String sufijo = texto.substring(i);

        raiz.insertarSufijo(sufijo, i);
    }
}
public TListaEnlazada<Integer> buscarPatron(String patron) {
    return raiz.buscarPatron(patron);
}
public List<Entry<T>> predecir(String prefijo) {
    return raiz.predecir(prefijo);
}


public void recorrer(Consumer<Entry<T>> consumer) {
    raiz.recorrer(consumer);
}
}
