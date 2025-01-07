package com.smart4aviation.queries;

import com.smart4aviation.airport.capacity.CapacityTable;

/**
 * <p>This query assigns plane to the route and sets maximum passenger capacity.</p>
 */
public class AssignPlaneChangeCapacityOnDay implements Query {
    private CapacityTable capacityTable;
    private final int planeId;
    private final int newCapacity;
    private final long day;

    public AssignPlaneChangeCapacityOnDay(int planeId, int capacity, long day) {
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
        return "A " + planeId + " " + newCapacity + " " + day;
    }

    @Override
    public void setCapacityTable(CapacityTable capacityTable) {
        this.capacityTable = capacityTable;
    }
}
