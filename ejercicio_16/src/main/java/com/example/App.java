package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        AGenealogico arbol = new AGenealogico();

        Persona Diego = new Persona(1950, "Abuelo Diego");
        Persona Olivera = new Persona(1970, "Olivera");
        Persona Trindade = new Persona(1972, "Trindade");
        Persona Escobar = new Persona(1975, "Escobar");
        Persona Indio = new Persona(1995, "Indio");
        Persona Leo = new Persona(1997, "Leo");
        Persona Lea = new Persona(1999, "Lea");
        Persona Mati = new Persona(1998, "Mati");
        Persona Eric = new Persona(2000, "Eric");
        Persona Brandon = new Persona(2002, "Brandon");

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

        System.out.println(arbol.listarDescendientes("Abuelo Diego"));
        System.out.println(arbol.altura());
        System.out.println(arbol.esDescendiente(Olivera, Indio));
        System.out.println(arbol.tamaño());
        System.out.println(arbol.ancestroComun("Brandon", "Eric"));
        System.out.println(arbol.obtenerGeneracion(1));

    }
}
