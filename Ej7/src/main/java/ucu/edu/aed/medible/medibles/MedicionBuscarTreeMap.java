package ucu.edu.aed.medible.medibles;

import java.util.List;
import java.util.Map;

import ucu.edu.aed.medible.lib.Medible;

public class MedicionBuscarTreeMap extends Medible<List<String>> {

    private Map<String, String> treeMap;

    public MedicionBuscarTreeMap(Map<String, String> treeMap) {
        this.treeMap = treeMap;
    }

    @Override
    public void ejecutar(int repeticion, List<String> params) {
        for (String s : params) {
            treeMap.containsKey(s);
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return treeMap;
    }
}