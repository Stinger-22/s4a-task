package com.smart4aviation.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestUtilities {
    @DisplayName("Successfully find next power of two")
    @ParameterizedTest(name = "{1} is nearest power of two for {0}")
    @CsvSource({"1, 1", "2, 2", "5, 8", "10, 16", "31, 32"})
    void nextPowerOfTwo(int value, int expected) {
        assertEquals(expected, Utilities.nextPowerOfTwo(value));
    }

    @DisplayName("Throw exception on invalid number for finding next power of two")
    @ParameterizedTest(name = "Invalid value {0}")
    @ValueSource(ints = {0, -1, -2, Integer.MIN_VALUE, Integer.MAX_VALUE})
    void invalidNextPowerOfTwo(int value) {
        assertThrows(IllegalArgumentException.class, () -> Utilities.nextPowerOfTwo(value));
    }
}
