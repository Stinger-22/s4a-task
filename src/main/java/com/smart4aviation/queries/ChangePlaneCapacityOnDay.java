package com.smart4aviation.queries;

public class ChangePlaneCapacityOnDay implements Query {
    private final int planeId;
    private final int newCapacity;
    private final long day;

    public ChangePlaneCapacityOnDay(int planeId, int capacity, long day) {
        this.planeId = planeId;
        this.newCapacity = capacity;
        this.day = day;
    }

    @Override
    public void execute() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String toString() {
        return "P " + planeId + " " + newCapacity + " " + day;
    }
}
