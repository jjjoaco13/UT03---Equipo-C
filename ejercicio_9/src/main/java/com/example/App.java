package com.example;
import com.example.tda.Report;
import com.example.tda.THashLineal;

import java.util.ArrayList;
 import java.util.HashSet;
 import java.util.Random;
 import java.util.Set;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int capacidadTabla = 1000;

        int[] factoresCarga = {
            70, 75, 80, 85, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99
        };

        System.out.println("Factor de carga | Prom.Comp. Inserción | Prom. Comp. Búsqueda existosa | Prom. Comp. Búsqueda no existosa");

        for (int factor : factoresCarga){
            Resultado resultado = ejecutaMedicion(capacidadTabla, factor);

            System.out.println(
                factor + "%|" +
                resultado.promedioInsercion + "|" +
                resultado.promedioBusquedaExitosa + "|" +
                resultado.promedioBusquedaNoExitosa
            );
        }
    }
    
    private static Resultado ejecutaMedicion(int capacidadTabla, int factorCarga){
        THashLineal<Integer, Integer> tabla = new THashLineal<>(capacidadTabla);

        int cantidadAInsertar = capacidadTabla * factorCarga / 100;

        Random random = new Random(12345 + factorCarga);

        ArrayList<Integer> clavesInsertadas = new ArrayList<>();
        Set<Integer> clavesUsadas = new HashSet<>();

        int totalComparacionesInsercion = 0;

        while (clavesInsertadas.size() < cantidadAInsertar) {
            int clave = random.nextInt(10_000_000);

            if (!clavesUsadas.contains(clave)) {
                clavesUsadas.add(clave);

                Report report = new Report();
                tabla.insertar(clave, clave, report);

                totalComparacionesInsercion += report.getCantidadComparaciones();
                clavesInsertadas.add(clave);
            }
        }

        int totalComparacionesBusquedaExitosa = 0;

        for (Integer clave : clavesInsertadas) {
            Report report = new Report();
            tabla.buscar(clave, report);
            totalComparacionesBusquedaExitosa += report.getCantidadComparaciones();
        }

        int cantidadBusquedasNoExitosas = cantidadAInsertar;
        int totalComparacionesBusquedaNoExitosa = 0;
        int realizadas = 0;

        while (realizadas < cantidadBusquedasNoExitosas) {
            int claveNoExistente = 20_000_000 + random.nextInt(10_000_000);

            if (!clavesUsadas.contains(claveNoExistente)) {
                Report report = new Report();
                tabla.buscar(claveNoExistente, report);
                totalComparacionesBusquedaNoExitosa += report.getCantidadComparaciones();
                realizadas++;
            }
        }

        double promedioInsercion = (double) totalComparacionesInsercion / cantidadAInsertar;
        double promedioBusquedaExitosa = (double) totalComparacionesBusquedaExitosa / cantidadAInsertar;
        double promedioBusquedaNoExitosa = (double) totalComparacionesBusquedaNoExitosa / cantidadBusquedasNoExitosas;

        return new Resultado(promedioInsercion, promedioBusquedaExitosa, promedioBusquedaNoExitosa);
    }
    private static class Resultado {
        double promedioInsercion;
        double promedioBusquedaExitosa;
        double promedioBusquedaNoExitosa;

        Resultado(double promedioInsercion, double promedioBusquedaExitosa, double promedioBusquedaNoExitosa) {
            this.promedioInsercion = promedioInsercion;
            this.promedioBusquedaExitosa = promedioBusquedaExitosa;
            this.promedioBusquedaNoExitosa = promedioBusquedaNoExitosa;
        }
    }
}
