package com.example;

import java.util.ArrayList;

public class AGenealogico extends ArbolGenerico<Persona> {

    public ArrayList<String> listarDescendientes(String nombre){
        ArrayList<String> devolver = new ArrayList<>();
        if (this.raiz==null){
            return null;
        }
        NodoGenerico<Persona> ancestro = buscar(new Persona(0, nombre));
        if (ancestro == null) return null;
        listarDescendientes(ancestro.getPrimerHijo(), devolver);
        return devolver;
    }
    
    public void listarDescendientes (NodoGenerico<Persona> nodo, ArrayList<String> descendientes){
        if(nodo==null){
            return;
        }
        descendientes.add(nodo.getDato().getNombre());
        listarDescendientes(nodo.getPrimerHijo(), descendientes);
        listarDescendientes(nodo.getSiguienteHermano(), descendientes);
    }

    public int altura(){
        return altura(this.raiz)-1;
    }
    
    private int altura(NodoGenerico<Persona> nodo) {
        if (nodo == null) return 0;
    
        int alturaHijo = 1 + altura(nodo.getPrimerHijo());
    
        NodoGenerico<Persona> hermano = nodo.getSiguienteHermano();
        while (hermano != null) {
            alturaHijo = Math.max(alturaHijo, 1 + altura(hermano.getPrimerHijo()));
            hermano = hermano.getSiguienteHermano();
        }
        return alturaHijo;
    }

    public int tamaño(){
        return tamaño(this.raiz);
    }

    public int tamaño(NodoGenerico<Persona> nodo){
        if (nodo==null){
            return 0;
        }
        return 1+ tamaño(nodo.getPrimerHijo())+ tamaño(nodo.getSiguienteHermano());
    }

    public ArrayList<String> obtenerGeneracion(int generacion){
        if(raiz==null){
            return null;
        }
        ArrayList<String> devolver = new ArrayList<>();
        obtenerGeneracion(generacion, 0, devolver, this.raiz);
        return devolver;
    }

    public void obtenerGeneracion(int generacion, int generacionActual, ArrayList<String> lista, NodoGenerico<Persona> nodo){
        if(nodo == null){
            return;
        }
        if(generacion==generacionActual){
            lista.add(nodo.getDato().getNombre());
        }
        obtenerGeneracion(generacion, generacionActual, lista, nodo.getSiguienteHermano());
        obtenerGeneracion(generacion, generacionActual+1, lista, nodo.getPrimerHijo());
    }

    public Persona ancestroComun(String nombre1, String nombre2){
        NodoGenerico<Persona> nodo1 = buscar(new Persona(0, nombre1));
        NodoGenerico<Persona> nodo2 = buscar(new Persona(0, nombre2));
        if(nodo1 == null || nodo2 == null) return null;
        return ancestroComun(nodo1.getDato(), nodo2.getDato(), this.raiz);
    }

    public Persona ancestroComun(Persona primera, Persona segunda, NodoGenerico<Persona> nodo){
        if(nodo==null){
            return null;
        }

        NodoGenerico<Persona> siguiente = nodo.getPrimerHijo();
        while(siguiente!=null){
            if(buscar(siguiente, primera)!=null && buscar(siguiente, segunda)!=null){
                return ancestroComun(primera, segunda, siguiente);
            }
            else{
                siguiente = siguiente.getSiguienteHermano();
            }
        }
        return nodo.getDato();
    }

    public boolean esDescendiente(Persona ancestro, Persona posible){
        NodoGenerico<Persona> ancestrox = buscar(ancestro);
        if (ancestrox==null){return false;}
        return buscar(ancestrox, posible)!=null;
    }
}
