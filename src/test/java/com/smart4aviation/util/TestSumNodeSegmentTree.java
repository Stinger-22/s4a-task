package com.smart4aviation.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestSumNodeSegmentTree {
    private SumNodeSegmentTree tree;

    @BeforeEach
    void setUp() {
        tree = new SumNodeSegmentTree(new int[]{1, 2, 3, 0, -1});
    }

    @DisplayName("Prevent creation of tree when no data is provided")
    @ParameterizedTest
    @NullAndEmptySource
    void invalidCreationData(int[] data) {
        assertThrows(IllegalArgumentException.class, () -> new SumNodeSegmentTree(data));
    }

    @DisplayName("Calculate sum of range")
    @ParameterizedTest(name = "Sum of range [{0}, {1}] is {2}")
    @CsvSource({"0, 0, 1", "1, 1, 2", "2, 2, 3", "3, 3, 0", "4, 4, -1", "0, 4, 5", "2, 4, 2"})
    void query(int left, int right, long expected) {
        assertEquals(expected, tree.query(left, right));
    }

    @DisplayName("Throw exception on invalid query range")
    @ParameterizedTest(name = "Invalid query range [{0}, {1}]")
    @CsvSource({"-1, 3", "2, 5", "-3, 10"})
    void outOfBoundsQuery(int left, int right) {
        assertThrows(IndexOutOfBoundsException.class, () -> tree.query(left, right));
    }

    @DisplayName("Throw exception when left boundary bigger than right")
    @Test
    void leftBoundaryBiggerThanRightQuery() {
        assertThrows(IllegalArgumentException.class, () -> tree.query(3, 1));
    }

    @DisplayName("Update tree with new value on position")
    @ParameterizedTest(name = "Set {1} on position {0}")
    @CsvSource({"0, 2, 6", "2, 6, 8", "4, 3, 9"})
    void update(int position, int newData, int expectedUpdatedSum) {
        tree.update(position, newData);
        assertEquals(expectedUpdatedSum, tree.query(0, 4));
    }

    @DisplayName("Throw exception on position which is out of bounds")
    @ParameterizedTest(name = "Invalid position {0}")
    @ValueSource(ints = {-1, 5})
    void invalidUpdate(int position) {
        assertThrows(IndexOutOfBoundsException.class, () -> tree.update(position, 1));
    }
}
