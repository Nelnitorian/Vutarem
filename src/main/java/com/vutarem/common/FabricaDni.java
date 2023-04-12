package com.vutarem.common;

public class FabricaDni {

    public static Dni creaDni(String dni_str) {
        Dni dni = null;
        if(dniValido(dni_str)){
            dni = new Dni(dni_str);
        }
        return dni;
    }

    private static boolean dniValido(String dni){
        return dni.matches("\\d{8}[A-Z]");
    }
}
