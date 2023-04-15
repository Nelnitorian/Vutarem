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
                
            // Obtener lista de candidatos
            List<Candidato> candidatos = Cliente.obtenerCandidatos();
    
            // Votar por un candidato
            Cliente cliente = new Cliente(dni, password);
            cliente.votar(1);
            

        });
        
    }
}
    
