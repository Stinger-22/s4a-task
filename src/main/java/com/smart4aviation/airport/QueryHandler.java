package com.smart4aviation.airport;

import com.smart4aviation.airport.capacity.CapacityTable;
import com.smart4aviation.queries.Query;

import java.util.Scanner;

/**
 * <p>Uses <code>QueryParser</code> to receive <code>Query</code> and execute it on <code>CapacityTable</code>.</p>
 */
public class QueryHandler {
    private final QueryParser parser;
    private CapacityTable capacityTable;

    public QueryHandler(Scanner scanner) {
        this.parser = new QueryParser(scanner);
    }

    void setCapacityTable(CapacityTable capacityTable) {
        this.capacityTable = capacityTable;
    }

    public void processQuery() {
        Query query = parser.next();
        query.setCapacityTable(capacityTable);
        query.execute();
    }

    public void processQuery(int numberOfQueries) {
        for (int i = 0; i < numberOfQueries; i++) {
            processQuery();
        }
    }

    public void processAllQueries() {
        Query query;
        while ((query = parser.next()) != null) {
            query.setCapacityTable(capacityTable);
            query.execute();
        }
    }
}
