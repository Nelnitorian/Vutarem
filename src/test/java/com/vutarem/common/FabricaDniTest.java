package com.vutarem.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FabricaDniTest {

    @Test
    public void testDniCorrecto() {
        assertNotNull(FabricaDni.creaDni("12345678A"));        
    }


    @Test
    public void testDniIncorrectoLetras() {
        assertNull(FabricaDni.creaDni("ABCDEFGHI"));        
    }

    @Test
    public void testDniIncorrectoTamanio() {
        assertNull(FabricaDni.creaDni("123456789A"));        
    }

}