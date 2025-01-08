package com.smart4aviation.airport;

import com.smart4aviation.airport.capacity.CapacityTable;
import com.smart4aviation.airport.view.ConsoleView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>Airport entity which handles all the incoming requests with the given <code>QueryHandler</code>.</p>
 * @see QueryHandler
 */
public class Airport {
    private static final Logger logger = LogManager.getLogger();

    private final CapacityTable capacityTable;
    private final QueryHandler queryHandler;
    private int numberOfQueries;

    /**
     * <p>Constructs airport entity and builds day-zero <code>CapacityTable</code>.</p>
     * @param planeCapacities initial planes' capacities.
     * @param numberOfQueries number of incoming queries to process.
     * @throws IllegalArgumentException if <code>scanner</code> is null, <code>planeCapacities</code> is null or have 0 length, <code>numberOfQueries</code> is less than one.
     */
    public Airport(Scanner scanner, int[] planeCapacities, int numberOfQueries) {
        if (scanner == null) {
            throw new IllegalArgumentException("Scanner cannot be null");
        }
        if (planeCapacities == null || planeCapacities.length == 0) {
            throw new IllegalArgumentException("planeCapacities cannot be null or empty");
        }
        if (numberOfQueries < 1) {
            throw new IllegalArgumentException("numberOfQueries cannot be less than 1");
        }
        this.numberOfQueries = numberOfQueries;
        this.capacityTable = new CapacityTable(planeCapacities);
        this.queryHandler = new QueryHandler(scanner, this.capacityTable, new ConsoleView());
        logger.debug("Created airport with initial plane capacities: {}", Arrays.toString(planeCapacities));
    }

    /**
     * <p>Process incoming queries.</p>
     */
    public void run() {
        logger.info("Airport started working");
        queryHandler.processQuery(numberOfQueries);
        logger.info("Airport finished working");
    }
}
