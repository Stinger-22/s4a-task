package com.smart4aviation.queries;

import com.smart4aviation.airport.capacity.CapacityTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <p>This query assigns plane to the route and sets maximum passenger capacity.</p>
 */
public class AssignPlaneChangeCapacityOnDay implements Query {
    private static final Logger logger = LogManager.getLogger();

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
        logger.info("Executing query A: assign plane {} with capacity {} on day {}", planeId, newCapacity, day);
        if (capacityTable.getLastDay() != day) {
            capacityTable.newDay(day);
        }
        capacityTable.update(planeId, newCapacity);
        logger.debug("CapacityTable after query execution\n{}", capacityTable.toString());
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
