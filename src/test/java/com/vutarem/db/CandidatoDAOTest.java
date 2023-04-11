package com.vutarem.db;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.vutarem.common.Candidato;

public class CandidatoDAOTest {

    @Test
    public void testBorra() {
        String nombre = "Ventana Marquez";
        String partido = "Testiario";
        Candidato cand = new Candidato(nombre, partido, 0);
        assertDoesNotThrow(() -> {
            ICandidatoDAO candao = new CandidatoDAO();
            candao.crea(cand);
            int id = candao.leeId(nombre, partido);
            candao.borra(id);
        });       
    }

    @Test
    public void testVota() {
        String nombre = "Almohada Sabanas";
        String partido = "Testiario";
        Candidato cand = new Candidato(nombre, partido, 0);
        assertDoesNotThrow(() -> {
            ICandidatoDAO candao = new CandidatoDAO();
            candao.crea(cand);
            int id = candao.leeId(nombre, partido);
            candao.vota(id);
            Candidato cand2 = candao.lee(id);
            assertTrue(cand2.getVotos() == 1);
            candao.borra(id);
        });        
    }
}