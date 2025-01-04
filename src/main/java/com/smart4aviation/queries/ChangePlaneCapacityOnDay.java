package com.smart4aviation.queries;

import com.smart4aviation.entities.Plane;

public class ChangePlaneCapacityOnDay implements Query {
    private Plane plane;
    private int newCapacity;
    private int day;

    public ChangePlaneCapacityOnDay(Plane plane, int capacity, int day) {
        this.plane = plane;
        this.newCapacity = capacity;
        this.day = day;
    }

    @Override
    public void execute() {
        throw new RuntimeException("Not implemented");
    }
}
