package com.smart4aviation.queries;

import com.smart4aviation.airport.capacity.CapacityTable;

/**
 * <p>This query changes plane maximum passenger capacity starting on the provided day.</p>
 */
public class ChangePlaneCapacityOnDay implements Query {
    private CapacityTable capacityTable;
    private final int planeId;
    private final int newCapacity;
    private final long day;

    public ChangePlaneCapacityOnDay(int planeId, int capacity, long day) {
        this.planeId = planeId;
        this.newCapacity = capacity;
        this.day = day;
    }

    @Override
    public void execute() {
        capacityTable.newDay(day);
        capacityTable.update(planeId, newCapacity);
    }

    @Override
    public String toString() {
        return "P " + planeId + " " + newCapacity + " " + day;
    }

    @Override
    public void setCapacityTable(CapacityTable capacityTable) {
        this.capacityTable = capacityTable;
    }
}
