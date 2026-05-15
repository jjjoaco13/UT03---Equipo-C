package ucu.edu.aed.medible.medibles;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ucu.edu.aed.medible.lib.Medible;

public class MedicionPredecirHashMap extends Medible<String> {

    private Map<String, String> hashMap;

    public MedicionPredecirHashMap(Map<String, String> hashMap) {

        this.hashMap = hashMap;
    }

    @Override
    public void ejecutar(int repeticion, String prefijo) {
        List<String> resultados =
                new LinkedList<>();
        for (String s : hashMap.keySet()) {
            if (s.startsWith(prefijo)) {
                resultados.add(s);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return hashMap;
    }
}