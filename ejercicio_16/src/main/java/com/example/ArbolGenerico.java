package com.example;

public class ArbolGenerico<T> implements TDAArbolGenerico<T>{
    protected NodoGenerico<T> raiz;

    @Override
    public void insertar(T padre, T dato) {
        NodoGenerico<T> nodoPadre = buscar(padre);
        if (nodoPadre == null) return;

        NodoGenerico<T> nuevoNodo = new NodoGenerico<>(dato);

        if (nodoPadre.getPrimerHijo() == null) {
            nodoPadre.setPrimerHijo(nuevoNodo);
        } else {
            NodoGenerico<T> hijo = nodoPadre.getPrimerHijo();
            while (hijo.getSiguienteHermano() != null) {
                hijo = hijo.getSiguienteHermano();
            }
            hijo.setSiguienteHermano(nuevoNodo);
        }
    }

    @Override
    public boolean eliminar(T dato) {
        if (raiz == null) return false;
        if (raiz.getDato().equals(dato)) {
            raiz = null;
            return true;
        }
        return eliminar(raiz, dato);
    }

    private boolean eliminar(NodoGenerico<T> nodo, T dato) {
        if (nodo == null) return false;

        NodoGenerico<T> hijo = nodo.getPrimerHijo();
        NodoGenerico<T> anterior = null;

        while (hijo != null) {
            if (hijo.getDato().equals(dato)) {
                if (anterior == null) {
                    nodo.setPrimerHijo(hijo.getSiguienteHermano());
                } else {
                    anterior.setSiguienteHermano(hijo.getSiguienteHermano());
                }
                return true;
            }
            anterior = hijo;
            hijo = hijo.getSiguienteHermano();
        }

        hijo = nodo.getPrimerHijo();
        while (hijo != null) {
            if (eliminar(hijo, dato)) return true;
            hijo = hijo.getSiguienteHermano();
        }
        return false;
    }

    @Override
    public NodoGenerico<T> buscar(T dato) {
        return buscar(raiz, dato);
}

    public NodoGenerico<T> buscar(NodoGenerico<T> nodo, T dato) {
        if (nodo == null) return null;
        if (nodo.getDato().equals(dato)) return nodo;
    
        NodoGenerico<T> encontrado = buscar(nodo.getPrimerHijo(), dato);
        if (encontrado != null) return encontrado;
    
        return buscar(nodo.getSiguienteHermano(), dato);
    }

    @Override
    public boolean estaVacio() {
        return this.raiz==null;
    }
    
}