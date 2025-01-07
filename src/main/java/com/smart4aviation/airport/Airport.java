package com.smart4aviation.airport;

import com.smart4aviation.airport.capacity.CapacityTable;

/**
 * <p>Airport entity which handles all the incoming requests with the given <code>QueryHandler</code>.</p>
 * @see QueryHandler
 */
public class Airport {
    private CapacityTable capacityTable;
    private QueryHandler queryHandler;
    private int numberOfQueries;

    /**
     * <p>Constructs airport entity and builds day-zero <code>CapacityTable</code>.</p>
     * @param planeCapacities initial planes' capacities.
     * @param numberOfQueries number of incoming queries to process.
     * @throws IllegalArgumentException if given array is null or have 0 length.
     */
    public Airport(int[] planeCapacities, int numberOfQueries) {
        if (planeCapacities == null || planeCapacities.length == 0) {
            throw new IllegalArgumentException("planeCapacities cannot be null or empty");
        }
        this.numberOfQueries = numberOfQueries;
        this.capacityTable = new CapacityTable(planeCapacities);
    }

    /**
     * <p>Process incoming queries.</p>
     */
    public void run() {
        if (queryHandler == null) {
            throw new IllegalStateException("QueryHandler is not set");
        }
        queryHandler.processQuery(numberOfQueries);
    }

    public void setQueryHandler(QueryHandler queryHandler) {
        this.queryHandler = queryHandler;
        this.queryHandler.setCapacityTable(capacityTable);
    }
}
