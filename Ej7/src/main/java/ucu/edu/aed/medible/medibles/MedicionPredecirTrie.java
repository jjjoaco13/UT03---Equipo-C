package ucu.edu.aed.medible.medibles;

import ucu.edu.aed.medible.lib.Medible;
import ucu.edu.aed.tda.trie.TTrie;

public class MedicionPredecirTrie extends Medible<String> {

    private TTrie<String> trie;

    public MedicionPredecirTrie(TTrie<String> trie) {

        this.trie = trie;
    }

    @Override
    public void ejecutar(int repeticion, String prefijo) {
        trie.predecir(prefijo);
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return trie;
    }
}