package com.vutarem.common;

public class Main {
    public static void main(String[] args) {
        Dni dni = FabricaDni.creaDni("12345678A");
        Votante votante = new Votante(dni, "juanito", false);
        System.out.println(votante.getDni().toString());
    }
    
}
