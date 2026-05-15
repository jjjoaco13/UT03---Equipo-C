package ucu.edu.aed.medible;


import ucu.edu.aed.medible.lib.Medible;
import ucu.edu.aed.medible.lib.Medicion;
import ucu.edu.aed.medible.medibles.MedicionBuscarArrayList;
import ucu.edu.aed.medible.medibles.MedicionBuscarHashMap;
import ucu.edu.aed.medible.medibles.MedicionBuscarLinkedList;
import ucu.edu.aed.medible.medibles.MedicionBuscarTreeMap;
import ucu.edu.aed.medible.medibles.MedicionBuscarTrie;
import ucu.edu.aed.medible.medibles.MedicionPredecirHashMap;
import ucu.edu.aed.medible.medibles.MedicionPredecirLinkedList;
import ucu.edu.aed.medible.medibles.MedicionPredecirTrie;
import ucu.edu.aed.tda.trie.TTrie;
import ucu.edu.aed.tda.trie.Trie;
import ucu.edu.aed.utils.FileUtils;

import java.util.*;

public class Main {

    private static final int REPETICIONES = 20;

    public static void main(String[] args) {
        TTrie<String> trie = new Trie<>();
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> treeMap = new TreeMap<>();

        List<String> palabrasParaAgregar = new LinkedList<>();
        List<String> palabrasParaBuscar = new LinkedList<>();
        FileUtils.leerLineas("./ut03/listado-general-desordenado.txt", palabrasParaAgregar::add);
        FileUtils.leerLineas("./ut03/listado-general-palabrasBuscar.txt", palabrasParaBuscar::add);

        for (String p : palabrasParaAgregar) {
            trie.insertar(p, p);
            linkedList.add(p);
            arrayList.add(p);
            hashMap.put(p, p);
            treeMap.put(p, p);
}
        List<Medible<List<String>>> medibles = new LinkedList<>();

        medibles.add(new MedicionBuscarLinkedList(linkedList));
        medibles.add(new MedicionBuscarArrayList(arrayList));
        medibles.add(new MedicionBuscarTrie(trie));
        medibles.add(new MedicionBuscarHashMap(hashMap));
        medibles.add(new MedicionBuscarTreeMap(treeMap));

        StringBuilder sb = new StringBuilder();
        sb.append("algoritmo,tiempo,memoria\n");


        List<Medible<String>> mediblesPrediccion = new LinkedList<>();

        mediblesPrediccion.add( new MedicionPredecirTrie(trie));
        mediblesPrediccion.add(new MedicionPredecirLinkedList(linkedList)); 
        mediblesPrediccion.add(new MedicionPredecirHashMap(hashMap));

        for (Medible<List<String>> m : medibles) {
            Medicion mi = m.medir(REPETICIONES, palabrasParaBuscar);
            mi.print();

            sb.append(mi.toCSV()).append("\n");
        }


        for (Medible<String> m : mediblesPrediccion) {
            Medicion mi = m.medir(REPETICIONES, "cas");
            mi.print();
            sb.append(mi.toCSV()).append("\n");
    }

        FileUtils.escribirLineas("./salida.csv",sb.toString());
    }
}