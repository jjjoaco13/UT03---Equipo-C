package com.example.tda;

import java.util.ArrayList;
import java.util.List;

public class THashLineal<K, V> extends THash<K, V>{
    private int cantidadElementos = 0;

    public THashLineal(int capacidad){
        super(capacidad);
    }
    
    @Override
    public V buscar(K clave, Report report) {
        int posicionInicial = functionHashing(clave);

        for (int i = 0; i < hashTable.length; i++){
            int posicion = (posicionInicial + i) % hashTable.length;

            report.setCantidadComparaciones(report.getCantidadComparaciones() + 1);

            TNodoHash<K, V> nodo = hashTable[posicion];

            if (nodo == null) {
                return null;
            }

            if (!nodo.isLoteLibre() && nodo.getClave().equals(clave)){
                return nodo.getValor();
            }
        }
        return null;
    }

    @Override
    public boolean insertar(K clave, V valor, Report report){
        int posicionInicial = functionHashing(clave);

        for (int i = 0; i < hashTable.length; i++){
            int posicion = (posicionInicial + i) % hashTable.length;

            report.setCantidadComparaciones(report.getCantidadComparaciones() + 1);

            TNodoHash<K, V> nodo = hashTable[posicion];

            if (nodo == null || nodo.isLoteLibre()) {
                hashTable[posicion] = new TNodoHash<>(clave, valor);
                cantidadElementos++;
                return true;
            }
            if (nodo.getClave().equals(clave)) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean delete(K clave, Report report){
        int posicionInicial = functionHashing(clave);

        for (int i = 0; i < hashTable.length; i++){
            int posicion = (posicionInicial + i) % hashTable.length;

            report.setCantidadComparaciones(report.getCantidadComparaciones() + 1);

            TNodoHash<K, V> nodo = hashTable[posicion];

            if (nodo == null){
                return false;
            }

            if (!nodo.isLoteLibre() && nodo.getClave().equals(clave)){
                nodo.setLoteLibre(true);
                cantidadElementos--;
                return true;
            }
        }
        return false;
    }

    @Override
    protected int functionHashing(K clave){
        return Math.abs(clave.hashCode() % hashTable.length);
    }

    @Override
    public boolean esVacio(){
        return cantidadElementos == 0;
    }

    @Override
    public void vaciar(){
        for (int i = 0; i < hashTable.length; i++){
            hashTable[i] = null;
        }
        cantidadElementos = 0;
    }
    @Override
    protected int calcularCapacidadOptima(int elementosEsperados){
        return elementosEsperados;
    }

    @Override
    protected boolean redimensionar(){
        return false;
    }

    @Override
    public Iterable<Entry<K, V>> entries(){
        List<Entry<K, V>> lista = new ArrayList<>();

        for (TNodoHash<K, V> nodo : hashTable){
            if (nodo != null && !nodo.isLoteLibre()){
                lista.add(nodo.getEntry());
            }
        }
        return lista;
    }

    @Override
    public Iterable<K> keys() {
        List<K> lista = new ArrayList<>();

        for (TNodoHash<K, V> nodo : hashTable) {
            if (nodo != null && !nodo.isLoteLibre()) {
                lista.add(nodo.getClave());
            }
        }

        return lista;
    }

    @Override
    public Iterable<V> values() {
        List<V> lista = new ArrayList<>();

        for (TNodoHash<K, V> nodo : hashTable) {
            if (nodo != null && !nodo.isLoteLibre()) {
                lista.add(nodo.getValor());
            }
        }

        return lista;
    }
}
