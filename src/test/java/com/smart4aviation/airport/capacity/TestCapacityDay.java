package com.smart4aviation.airport.capacity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCapacityDay {
    @DisplayName("Throw exception on negative day")
    @ParameterizedTest(name = "Invalid day {0}")
    @ValueSource(ints = {-1, -4})
    void invalidCreation(int day) {
        assertThrows(IllegalArgumentException.class, () -> new CapacityDay(new int[]{1, 2}, day));
    }
}
