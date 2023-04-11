package com.vutarem.common;

public class Votante {
    private Dni dni = null;
    private String nombre = null;
    private boolean ha_votado = false;
    private String contrasenia = null;
    
    public Votante(Dni dni, String nombre, boolean ha_votado, String contrasenia){
        this.dni = dni;
        this.nombre = nombre;
        this.ha_votado = ha_votado;
        this.contrasenia = contrasenia;
    }

    public Votante(Dni dni, String nombre, boolean ha_votado){
        this.dni = dni;
        this.nombre = nombre;
        this.ha_votado = ha_votado;
    }

    public Dni getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isHa_votado() {
        return ha_votado;
    }

    public String getContrasenia() {
        return contrasenia;
    }

}
