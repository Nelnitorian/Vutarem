package com.vutarem.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FabricaDniTest {

    @Test
    public void testFabricaDni() {
        assertTrue(FabricaDni.creaDni("12345678A") != null);        
    }

}