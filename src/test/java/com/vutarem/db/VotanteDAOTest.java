package com.vutarem.db;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.vutarem.common.FabricaDni;
import com.vutarem.common.Votante;

public class VotanteDAOTest {

    @Test
    public void testBorra() {
        String dni_str = "88888888Z";
        Votante persona = new Votante(FabricaDni.creaDni(dni_str), "Maria Sanchez", false, "test");
        assertDoesNotThrow(() -> {
            IVotanteDAO votdao = new VotanteDAO();
            votdao.crea(persona);
            votdao.borra(dni_str);
        });       
    }

    @Test
    public void testActualiza() {
        String dni_str = "66666666Z";
        Votante persona = new Votante(FabricaDni.creaDni(dni_str), "Olga Sabueso", false, "test");
        assertDoesNotThrow(() -> {
            IVotanteDAO votdao = new VotanteDAO();
            votdao.crea(persona);
            votdao.actualiza(dni_str, true);
            assertTrue(votdao.lee(dni_str).isHa_votado());
            votdao.borra(dni_str);
            
        });
    }

    @Test
    public void testLee() {
        String dni_str = "55555555Z";
        Votante persona = new Votante(FabricaDni.creaDni(dni_str), "Pepino De Mar", false, "test");
        assertDoesNotThrow(() -> {
            IVotanteDAO votdao = new VotanteDAO();
            votdao.crea(persona);
            assertNotNull(votdao.lee(dni_str));
            votdao.borra(dni_str);
        });
    }

    @Test
    public void testLeeTodos() {
        String dni_str = "44444444Z";
        Votante persona = new Votante(FabricaDni.creaDni(dni_str), "Tarik Perez", false, "test");
        assertDoesNotThrow(() -> {
            IVotanteDAO votdao = new VotanteDAO();
            votdao.crea(persona);
            votdao.borra(dni_str);
            assertTrue(votdao.leeTodos().size()>0);
        });  
    }
}