package com.smart4aviation.airport.capacity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCapacityTable {
    private CapacityTable table;

    @BeforeEach
    void setUp() {
        table = new CapacityTable(new int[]{1, 2, 3, 0, -1});
    }

    @Test
    void newDay() {
        table.newDay(9);
        assertEquals(9, table.getLastDay());
    }

    @Test
    void update() {
        table.update(3, 10);
        assertEquals(new BigInteger("15"), table.findTotalCapacity(0, 4, 1));
    }

    @Test
    void remove() {
        table.remove(4);
        assertEquals(new BigInteger("12"), table.findTotalCapacity(0, 4, 2));
    }

    @Test
    void findTotalCapacity() {
        assertEquals(new BigInteger("36"), table.findTotalCapacity(0, 2, 6));
    }
}
