package ucu.edu.aed.medible.medibles;

import java.util.LinkedList;
import java.util.List;

import ucu.edu.aed.medible.lib.Medible;

public class MedicionPredecirLinkedList extends Medible<String> {

    private LinkedList<String> lista;

    public MedicionPredecirLinkedList( LinkedList<String> lista) {
        this.lista = lista;
    }

    @Override
    public void ejecutar(int repeticion, String prefijo) {

        List<String> resultados = new LinkedList<>();
        for (String s : lista) {
            if (s.startsWith(prefijo)) {
                resultados.add(s);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return lista;
    }
}