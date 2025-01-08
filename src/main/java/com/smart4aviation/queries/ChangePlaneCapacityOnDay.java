package com.smart4aviation.queries;

import com.smart4aviation.airport.capacity.CapacityTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <p>This query changes plane maximum passenger capacity starting on the provided day.</p>
 */
public class ChangePlaneCapacityOnDay implements Query {
    private static final Logger logger = LogManager.getLogger();

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
        logger.info("Executing query P: plane {} change capacity to {} on day {}", planeId, newCapacity, day);
        if (capacityTable.getLastDay() != day) {
            capacityTable.newDay(day);
        }
        capacityTable.update(planeId, newCapacity);
        logger.debug("CapacityTable after query execution\n{}", capacityTable.toString());
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
