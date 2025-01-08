package com.smart4aviation.airport.view;

import com.smart4aviation.queries.Query;
import com.smart4aviation.queries.TotalCapacityByPlanesActiveOnDay;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleView implements View {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void show(Query query) {
        if (query instanceof TotalCapacityByPlanesActiveOnDay q) {
            System.out.println(q.getTotalCapacity());
            logger.info("Showed result of TotalCapacityByPlanesActiveOnDay query in console");
        }
    }
}
