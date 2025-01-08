package com.smart4aviation.airport;

import com.smart4aviation.airport.capacity.CapacityTable;
import com.smart4aviation.airport.view.View;
import com.smart4aviation.queries.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * <p>Uses <code>QueryParser</code> to receive <code>Query</code> and execute it on <code>CapacityTable</code>.</p>
 */
public class QueryHandler {
    private static final Logger logger = LogManager.getLogger();

    private final QueryParser parser;
    private final CapacityTable capacityTable;
    private final View view;

    public QueryHandler(Scanner scanner, CapacityTable capacityTable, View view) {
        this.parser = new QueryParser(scanner);
        this.capacityTable = capacityTable;
        this.view = view;
    }

    public void processQuery() {
        Query query = parser.next();
        logger.info("Processing query: {}", query);
        query.setCapacityTable(capacityTable);
        query.execute();
        view.show(query);
    }

    public void processQuery(int numberOfQueries) {
        for (int i = 0; i < numberOfQueries; i++) {
            processQuery();
        }
    }

    public void processAllQueries() {
        while (parser.hasNext()) {
            processQuery();
        }
    }
}
