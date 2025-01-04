package com.smart4aviation.queries;

public class TotalCapacityByPlanesActiveOnDay implements Query {
    private int firstRoute;
    private int lastRoute;
    private int day;

    public TotalCapacityByPlanesActiveOnDay(int firstRoute, int lastRoute, int day) {
        this.firstRoute = firstRoute;
        this.lastRoute = lastRoute;
        this.day = day;
    }

    @Override
    public void execute() {
        throw new RuntimeException("Not implemented");
    }
}
