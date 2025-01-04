package com.smart4aviation.queries;

import com.smart4aviation.entities.Plane;

public class RemovePlaneOnDay implements Query {
    private int planeId;
    private long day;

    public RemovePlaneOnDay(int planeId, long day) {
        this.planeId = planeId;
        this.day = day;
    }

    @Override
    public void execute() {
        throw new RuntimeException("Not implemented");
    }
}
