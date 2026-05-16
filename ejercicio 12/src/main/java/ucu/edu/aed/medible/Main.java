package ucu.edu.aed.medible;

import ucu.edu.aed.tda.trie.Entry;
import ucu.edu.aed.tda.trie.TtrieHashMap;

public class Main {

    public static void main(String[] args) {

        TtrieHashMap<String> trie = new TtrieHashMap<>();

        System.out.println("---..--\nBUSQUEDA:---..--");
        trie.insertar("casa", "dato casa");
        trie.insertar("casco", "dato casco");

        Entry<String> buscado = trie.buscar("casa");

        if (buscado != null) {
            System.out.println(buscado.getPalabra());
            System.out.println(buscado.getDato());
        }
        TtrieHashMap<String> trie2 = new TtrieHashMap<>();
System.out.println("---..--\npatrones :---..--");
trie2.insertarSufijos("banana");

System.out.println(
        trie2.buscarPatron("ana")
);
System.out.println("---..--\nAUTOCOMPLETAR:---..--");
for (Entry<String> e : trie.predecir("cas")) {
    System.out.println(e.getPalabra());
}
    }
}