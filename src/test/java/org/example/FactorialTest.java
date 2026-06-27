package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class FactorialTest {

    private final Factorial obj = new Factorial();

    @ParameterizedTest(name = "Factorial of {0} should be {1}")
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120"
    })
    void testFactorialWithMultipleInputs(int input, int expectedOutput) {
        assertEquals(expectedOutput, obj.factorial(input));
    }
}
