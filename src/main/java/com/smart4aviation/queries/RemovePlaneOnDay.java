package com.smart4aviation.queries;

import com.smart4aviation.airport.capacity.CapacityTable;

/**
 * <p>This query removes plane from routes starting on the provided day.</p>
 */
public class RemovePlaneOnDay implements Query {
    private CapacityTable capacityTable;
    private final int planeId;
    private final long day;

    public RemovePlaneOnDay(int planeId, long day) {
        this.planeId = planeId;
        this.day = day;
    }

    @Override
    public void execute() {
        capacityTable.remove(planeId);
    }

    @Override
    public String toString() {
        return "C " + planeId + " " + day;
    }

    @Override
    public void setCapacityTable(CapacityTable capacityTable) {
        this.capacityTable = capacityTable;
    }
}
