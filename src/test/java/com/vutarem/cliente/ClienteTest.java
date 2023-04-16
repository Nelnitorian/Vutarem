package com.vutarem.cliente;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ClienteTest {
    

    @Test
    public void testVota(){   

        String dni = "12345678A";
        String password = "juanpi14";
        assertDoesNotThrow(() -> {
            // Obtener lista de candidatos
            Cliente.obtenerCandidatos();
    
            // Votar por un candidato
            Cliente cliente = new Cliente(dni, password);
            cliente.votar(1);
        });
        
    }
}
    
