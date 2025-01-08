package com.smart4aviation.queries;

import com.smart4aviation.airport.capacity.CapacityTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <p>This query removes plane from routes starting on the provided day.</p>
 */
public class RemovePlaneOnDay implements Query {
    private static final Logger logger = LogManager.getLogger();

    private CapacityTable capacityTable;
    private final int planeId;
    private final long day;

    public RemovePlaneOnDay(int planeId, long day) {
        this.planeId = planeId;
        this.day = day;
    }

    @Override
    public void execute() {
        logger.info("Executing query C: remove plane {} since day {}", planeId, day);
        capacityTable.remove(planeId);
        logger.debug("CapacityTable after query execution\n{}", capacityTable.toString());
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
