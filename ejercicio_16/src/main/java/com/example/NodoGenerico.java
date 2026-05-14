package com.example;

public class NodoGenerico<T>  {
    private T dato;
    private NodoGenerico<T> siguienteHermano;
    private NodoGenerico<T> primerHijo;

    

    public NodoGenerico (T dato){
        this.dato = dato;
        this.siguienteHermano=null;
        this.primerHijo=null;
    }

    public NodoGenerico<T> getSiguienteHermano() {
        return siguienteHermano;
    }
    public NodoGenerico<T> getPrimerHijo() {
        return primerHijo;
    }
    public T getDato() {
        return dato;
    }

    public void setSiguienteHermano(NodoGenerico<T> siguienteHermano) {
        this.siguienteHermano = siguienteHermano;
    }

    public void setPrimerHijo(NodoGenerico<T> primerHijo) {
        this.primerHijo = primerHijo;
    }
    
}
