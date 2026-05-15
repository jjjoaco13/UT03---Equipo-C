package ucu.edu.aed.medible.medibles;

import java.util.ArrayList;
import java.util.List;

import ucu.edu.aed.medible.lib.Medible;

public class MedicionBuscarArrayList extends Medible<List<String>> {

    private ArrayList<String> arrayList;

    public MedicionBuscarArrayList( ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void ejecutar(int repeticion, List<String> params) {
        
        for (String s : params) {
            arrayList.contains(s);
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return arrayList;
    }
}