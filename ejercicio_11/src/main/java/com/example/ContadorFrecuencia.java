package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContadorFrecuencia{
    HashMap<String, Integer> apariciones;

     public ContadorFrecuencia() {
        this.apariciones = new HashMap<>();
    }

    public static String[] leerArchivo(String nombreCompletoArchivo) {
        ArrayList<String> listaLineasArchivo = new ArrayList<>();
        try (FileReader fr = new FileReader(nombreCompletoArchivo);
             BufferedReader br = new BufferedReader(fr)) {
            String lineaActual;
            while ((lineaActual = br.readLine()) != null) {
                listaLineasArchivo.add(lineaActual);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }
        System.out.println("Archivo leído satisfactoriamente");

        return listaLineasArchivo.toArray(new String[0]);
    }

    public StringBuilder graficarOcurrencias(String nombre){
        String[] lineas = leerArchivo(nombre);
        for(String linea: lineas){
            String[] lineaActual = linea.toLowerCase().replaceAll("[^a-záéíóúüñ ]", "").split("\\s+");
            for(String palabra:lineaActual){
                apariciones.put(palabra, apariciones.getOrDefault(palabra, 0) + 1);
                }
            }
        
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(apariciones.entrySet());
        lista.sort(new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
            return b.getValue() - a.getValue();
        }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++){
            sb.append("TOP ").append(i+1).append(": ").append(lista.get(i).toString()).append("\n");
        }
        return sb;
}
    
}