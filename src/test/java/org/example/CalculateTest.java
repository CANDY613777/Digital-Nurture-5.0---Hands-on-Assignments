package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {

        @Test
        void testAddition() {
            Calculate calc = new Calculate();
            int result = calc.add(5, 3);
            assertEquals(8, result);

        }
    @Test
    void testSubtraction() {
        Calculate calc = new Calculate();
        int result = calc.subtract(5, 3);
        assertEquals(2, result);

    }
    }
