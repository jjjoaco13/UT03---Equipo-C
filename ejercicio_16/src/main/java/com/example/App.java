package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        AGenealogico arbol = new AGenealogico();

        Persona Diego = new Persona(1950, "Abuelo");
        Persona Olivera = new Persona(1970, "Hijo1");
        Persona Trindade = new Persona(1972, "Hijo2");
        Persona Escobar = new Persona(1975, "Hijo3");
        Persona Indio = new Persona(1995, "Nieto1");
        Persona Leo = new Persona(1997, "Nieto2");
        Persona Lea = new Persona(1999, "Nieto3");
        Persona Mati = new Persona(1998, "Nieto4");
        Persona Eric = new Persona(2000, "Nieto5");
        Persona Brandon = new Persona(2002, "Nieto6");

        arbol.insertar(Diego);
        arbol.insertar(Diego, Olivera);
        arbol.insertar(Diego, Trindade);
        arbol.insertar(Diego, Escobar);
        arbol.insertar(Olivera, Indio);
        arbol.insertar(Olivera, Leo);
        arbol.insertar(Olivera, Lea);
        arbol.insertar(Trindade, Mati);
        arbol.insertar(Trindade, Eric);
        arbol.insertar(Escobar, Brandon);
    }
}
