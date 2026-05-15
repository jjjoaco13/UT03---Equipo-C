package ucu.edu.aed.medible.medibles;

import java.util.List;

import ucu.edu.aed.medible.lib.Medible;
import ucu.edu.aed.tda.trie.TTrie;

public class MedicionBuscarTrie extends Medible<List<String>> {

    private TTrie<String> trie;

    public MedicionBuscarTrie(TTrie<String> trie) {

        this.trie = trie;
    }

    @Override
    public void ejecutar(int repeticion, List<String> params) {
        for (String s : params) {
            trie.buscar(s);
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return trie;
    }}