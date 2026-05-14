package com.example;

public class Persona {
    public int nacimiento;
    public String nombre;
 
    public Persona(int año, String name){
        this.nacimiento = año;
        this.nombre = name;
    }

    public int getNacimiento() {
        return nacimiento;
    }
    public String getNombre() {
        return nombre;
    }
    
    public boolean equals(Persona otro){
        return nombre.toLowerCase()==otro.getNombre().toLowerCase();
    }
}
