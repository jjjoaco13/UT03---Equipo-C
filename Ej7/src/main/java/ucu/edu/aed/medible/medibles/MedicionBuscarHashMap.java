package ucu.edu.aed.medible.medibles;

import java.util.List;
import java.util.Map;

import ucu.edu.aed.medible.lib.Medible;

public class MedicionBuscarHashMap extends Medible<List<String>> {

    private Map<String, String> hashMap;

    public MedicionBuscarHashMap(Map<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void ejecutar(int repeticion, List<String> params) {
        for (String s : params) {
            hashMap.containsKey(s);
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return hashMap;
    }
}