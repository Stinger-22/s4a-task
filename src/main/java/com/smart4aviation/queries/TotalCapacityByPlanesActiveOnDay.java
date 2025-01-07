package com.smart4aviation.queries;

import com.smart4aviation.airport.capacity.CapacityTable;

import java.math.BigInteger;

/**
 * <p>Calculates total historic sum of active planes on an interval since day 0 to the provided day.</p>
 */
public class TotalCapacityByPlanesActiveOnDay implements Query {
    private CapacityTable capacityTable;
    private final int firstRoute;
    private final int lastRoute;
    private final long day;
    private BigInteger totalCapacity;

    public TotalCapacityByPlanesActiveOnDay(int firstRoute, int lastRoute, long day) {
        this.firstRoute = firstRoute;
        this.lastRoute = lastRoute;
        this.day = day;
    }

    @Override
    public void execute() {
        totalCapacity = capacityTable.findTotalCapacity(firstRoute, lastRoute, day);
    }

    @Override
    public String toString() {
        return "Q " + firstRoute + " " + lastRoute + " " + day;
    }

    @Override
    public void setCapacityTable(CapacityTable capacityTable) {
        this.capacityTable = capacityTable;
    }

    public BigInteger getTotalCapacity() {
        return totalCapacity;
    }
}
