package com.smart4aviation.queries;

import com.smart4aviation.entities.Plane;

public class RemovePlaneOnDay implements Query {
    private Plane plane;
    private int day;

    public RemovePlaneOnDay(Plane plane, int day) {
        this.plane = plane;
        this.day = day;
    }

    @Override
    public void execute() {
        throw new RuntimeException("Not implemented");
    }
}
