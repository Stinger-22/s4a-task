package com.smart4aviation.airport.capacity;

import com.smart4aviation.util.SumNodeSegmentTree;

/**
 * <p>Child class of <code>SumNodeSegmentTree</code> with <code>day</code> field for airport capacity calculation.</p>
 * @see SumNodeSegmentTree
 */
public class CapacityDay extends SumNodeSegmentTree {
    private final long day;

    public CapacityDay(int[] data, long day) {
        super(data);
        this.day = day;
    }

    public CapacityDay(CapacityDay capacityDay, long day) {
        super(capacityDay, true);
        this.day = day;
    }

    public long getDay() {
        return day;
    }
}
