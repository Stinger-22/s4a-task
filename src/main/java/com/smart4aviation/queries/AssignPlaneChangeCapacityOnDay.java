package com.smart4aviation.queries;

public class AssignPlaneChangeCapacityOnDay implements Query {
    private int planeId;
    private int newCapacity;
    private long day;

    public AssignPlaneChangeCapacityOnDay(int planeId, int capacity, long day) {
        this.planeId = planeId;
        this.newCapacity = capacity;
        this.day = day;
    }

    @Override
    public void execute() {
        throw new RuntimeException("Not implemented");
    }
}
