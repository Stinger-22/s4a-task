package com.smart4aviation.airport.capacity;

import com.smart4aviation.util.SumNodeSegmentTree;

/**
 * <p>Child class of <code>SumNodeSegmentTree</code> with <code>day</code> field for airport capacity calculation.</p>
 * @see SumNodeSegmentTree
 */
public class CapacityDay extends SumNodeSegmentTree {
    private final long day;

    /**
     * <p>Saves associated with it day.</p>
     * @param data with which data is associated.
     * @throws IllegalArgumentException if day is negative.
     * @see SumNodeSegmentTree#SumNodeSegmentTree(int[])
     */
    public CapacityDay(int[] data, long day) {
        super(data);
        if (day < 0) {
            throw new IllegalArgumentException("day cannot be negative");
        }
        this.day = day;
    }

    /**
     * <p>Constructs copy of <code>CapacityDay</code> with shared root but with another day value.</p>
     * <p>This constructor is useful for implementing Persistent Segment Tree.</p>
     * @param capacityDay from which to copy.
     * @param day new day value.
     */
    CapacityDay(CapacityDay capacityDay, long day) {
        super(capacityDay, true);
        if (day < 0) {
            throw new IllegalArgumentException("day cannot be negative");
        }
        this.day = day;
    }

    public long getDay() {
        return day;
    }
}
