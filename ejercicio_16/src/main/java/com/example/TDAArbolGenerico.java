package com.example;

public interface TDAArbolGenerico<T> {
    void insertar(T padre, T dato);
    boolean eliminar(T dato);
    NodoGenerico<T> buscar(T dato);
    boolean estaVacio();
}