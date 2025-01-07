package com.smart4aviation.airport.view;

import com.smart4aviation.queries.Query;
import com.smart4aviation.queries.TotalCapacityByPlanesActiveOnDay;

public class ConsoleView implements View {
    @Override
    public void show(Query query) {
        if (query instanceof TotalCapacityByPlanesActiveOnDay q) {
            System.out.println(q.getTotalCapacity());
        }
    }
}
