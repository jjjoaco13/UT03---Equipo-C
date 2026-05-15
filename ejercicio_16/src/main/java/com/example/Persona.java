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

    public boolean equals(Object obj){
        if (this==obj){return true;}
        if(!(obj instanceof Persona)){return false;}
        Persona otro = (Persona) obj;
        return nombre.toLowerCase().equals(otro.getNombre().toLowerCase());
    }

    @Override
    public String toString(){
        return this.nombre;
    }
}
