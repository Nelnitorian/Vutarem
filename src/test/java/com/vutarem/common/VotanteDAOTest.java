package com.vutarem.common;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.vutarem.db.VotanteDAO;

import java.util.List;

public class VotanteDAOTest {

    // @Test
    // public void testCrea() {
    //     Votante persona = new Votante(FabricaDni.creaDni("99999999Z"), "Pepito Perez", false);
    //     boolean ejecucion_correcta = true;
    //     try{
    //         VotanteDAO.crea(persona);
    //     } catch (SQLException e){
    //         ejecucion_correcta = false;
    //         e.printStackTrace();
    //     }
    //     assertTrue(ejecucion_correcta);        
    // }


    @Test
    public void testBorra() {
        String dni_str = "88888888Z";
        Votante persona = new Votante(FabricaDni.creaDni(dni_str), "Maria Sanchez", false);
        boolean ejecucion_correcta = true;
        try{
            VotanteDAO.crea(persona);
            VotanteDAO.borra(dni_str);
        } catch (SQLException e){
            ejecucion_correcta = false;
            e.printStackTrace();
        }
        assertTrue(ejecucion_correcta);            
    }

    // @Test
    // public void testBorraTodos() {
    //     String dni_str = "77777777Z";
    //     Votante persona = new Votante(FabricaDni.creaDni(dni_str), "Ana Romero", false);
    //     boolean ejecucion_correcta = true;
    //     try{
    //         VotanteDAO.crea(persona);
    //         VotanteDAO.borraTodos();
    //     } catch (SQLException e){
    //         ejecucion_correcta = false;
    //         e.printStackTrace();
    //     }
    //     assertTrue(ejecucion_correcta);  
    // }

    @Test
    public void testActualiza() {
        String dni_str = "66666666Z";
        Votante persona = new Votante(FabricaDni.creaDni(dni_str), "Olga Sabueso", false);
        boolean ejecucion_correcta = true;
        Votante persona_actualizada = null;
        try{
            VotanteDAO.crea(persona);
            VotanteDAO.actualiza(dni_str, true);
            persona_actualizada = VotanteDAO.lee(dni_str);
            VotanteDAO.borra(dni_str);
            
        } catch (SQLException e){
            ejecucion_correcta = false;
            e.printStackTrace();
        }
        assertTrue(ejecucion_correcta);
        assertTrue(persona_actualizada.isHa_votado());
    }

    @Test
    public void testLee() {
        String dni_str = "55555555Z";
        Votante persona = new Votante(FabricaDni.creaDni(dni_str), "Olga Sabueso", false);
        boolean ejecucion_correcta = true;
        Votante a = null;
        try{
            VotanteDAO.crea(persona);
            a = VotanteDAO.lee(dni_str);
        } catch (SQLException e){
            ejecucion_correcta = false;
            e.printStackTrace();
        }
        assertTrue(ejecucion_correcta);
        assertNotNull(a);         
    }

    @Test
    public void testLeeTodos() {
        String dni_str = "44444444Z";
        Votante persona = new Votante(FabricaDni.creaDni(dni_str), "Olga Sabueso", false);
        boolean ejecucion_correcta = true;
        List<Votante> a = null;
        try{
            VotanteDAO.crea(persona);
            a = VotanteDAO.leeTodos();
        } catch (SQLException e){
            ejecucion_correcta = false;
            e.printStackTrace();
        }
        assertTrue(ejecucion_correcta);    
        assertTrue(a.size()>0);
    }

    // @AfterAll
    // public static void testReset() {
    //     try{
    //         // VotanteDAO.borraTodos();

    //         String[] args = new String[] {"/bin/bash", "../../../../../../scripts/dbinit.sh"};
    //         Process proc = new ProcessBuilder(args).start();

    //         List<Votante> lst = VotanteDAO.leeTodos();
    //         System.out.println(lst.size());
    //         assertTrue(lst.size() == 5);

    //     } catch (Exception e){
    //         e.printStackTrace();
    //         // ignore
    //     }
    // }
}