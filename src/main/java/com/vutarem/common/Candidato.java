package com.vutarem.common;

public class Candidato {
    
    private int id = 0;
    private String nombre = null;
    private String partido = null;
    private int votos = 0;
    
    public Candidato(int id, String nombre, String partido, int votos){
        this.id = id;
        this.nombre = nombre;
        this.partido = partido;
        this.votos = votos;
    }
    
    public Candidato(String nombre, String partido, int votos){
        this.nombre = nombre;
        this.partido = partido;
        this.votos = votos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPartido() {
        return partido;
    }

    public int getVotos() {
        return votos;
    }


}

