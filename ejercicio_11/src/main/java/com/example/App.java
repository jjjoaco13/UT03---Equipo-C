package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ContadorFrecuencia contador = new ContadorFrecuencia();
        System.out.println(contador.graficarOcurrencias("ejercicio_11/libro.txt"));
    }
}
