package com.java.spring.demo.mycoolapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {
    @Test
    void testAdd(){
        //SimpleCalculator calc = new SimpleCalculator();
        var calc = new SimpleCalculator();
        assertEquals(4,calc.add(2,2));

   /*     assertTrue(calc.add(2,2)==4);
        assertNotEquals();
        assertFalse();
        assertNull();
        assertNotNull();*/

    }

}