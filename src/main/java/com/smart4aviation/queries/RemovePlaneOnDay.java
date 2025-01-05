package com.smart4aviation.queries;

public class RemovePlaneOnDay implements Query {
    private final int planeId;
    private final long day;

    public RemovePlaneOnDay(int planeId, long day) {
        this.planeId = planeId;
        this.day = day;
    }

    @Override
    public void execute() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String toString() {
        return "C " + planeId + " " + day;
    }
}
