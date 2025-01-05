package com.smart4aviation.queries;

public class TotalCapacityByPlanesActiveOnDay implements Query {
    private final int firstRoute;
    private final int lastRoute;
    private final long day;

    public TotalCapacityByPlanesActiveOnDay(int firstRoute, int lastRoute, long day) {
        this.firstRoute = firstRoute;
        this.lastRoute = lastRoute;
        this.day = day;
    }

    @Override
    public void execute() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String toString() {
        return "Q " + firstRoute + " " + lastRoute + " " + day;
    }
}
