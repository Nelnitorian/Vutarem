package com.vutarem.cliente;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.vutarem.common.Candidato;


public class ClienteTest {
    

    @Test
    public void testVota(){   

        String dni = "12345678A";
        String password = "password";
        assertDoesNotThrow(() -> {
        
            Cliente cliente = new Cliente(dni, password);
                
            // Obtener lista de candidatos
            List<Candidato> candidatos = cliente.obtenerCandidatos();
    
            // Votar por un candidato
            cliente.votar(1);
            

        });
        
    }
}
    
