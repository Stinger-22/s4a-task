package com.smart4aviation.airport.capacity;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>Implementation of Persistent Segment Tree which uses <code>Deque</code> for saving root nodes of each tree.</p>
 * <p>Each element of <code>Deque</code> has saved state of airport planes capacities. When query which changes state is processed (except removing plane), new state is saved in the <code>Deque</code>. Each instance of <code>CapacityDay</code> shares nodes which are not updated, so it's memory efficient.</p>
 */
public class CapacityTable {
    private final Deque<CapacityDay> table;

    public CapacityTable(int[] dayZeroCapacities) {
        table = new ArrayDeque<>();
        table.add(new CapacityDay(dayZeroCapacities, 0));
    }

    /**
     * <p>Old airport capacity state is saved in history. Creates new state in the system which is ready to be modified by the queries.</p>
     * @param day on which the state expects changes.
     */
    public void newDay(long day) {
        table.push(new CapacityDay(getLastCapacityDay(), day));
    }

    /**
     * <p>Updates last-day state giving a plane new capacity.</p>
     * @param position of plane.
     * @param newData new capacity of plane.
     */
    public void update(int position, int newData) {
        getLastCapacityDay().update(position, newData);
    }

    /**
     * <p>Removes plane from the last day and each historic state.</p>
     * @param position of plane.
     */
    public void remove(int position) {
        for (CapacityDay capacityDay : table) {
            capacityDay.update(position, 0);
        }
    }

    /**
     * <p>Calculates historic sum from day 0 to the given day of airport daily capacity on a given route segment.</p>
     * @param firstRoute start of the segment.
     * @param lastRoute end of the segment.
     * @param day historic sum up to the given day.
     * @return total airport capacity.
     */
    public BigInteger findTotalCapacity(int firstRoute, int lastRoute, long day) {
        BigInteger totalCapacity = BigInteger.ZERO;
        for (CapacityDay capacityDay : table) {
            BigInteger capacityOnDay = BigInteger.valueOf(capacityDay.query(firstRoute, lastRoute));
            BigInteger numberOfDays = new BigInteger(String.valueOf(day - capacityDay.getDay()));
            totalCapacity = totalCapacity.add(capacityOnDay.multiply(numberOfDays));
            day -= day - capacityDay.getDay();
        }
        return totalCapacity;
    }

    public long getLastDay() {
        return getLastCapacityDay().getDay();
    }

    public void print() {
        System.out.println("============");
        System.out.println("CapacityTable: ");
        for (CapacityDay capacityDay : table) {
            System.out.print("D" + capacityDay.getDay() + " ");
            capacityDay.printLastRow();
            System.out.println();
        }
    }

    private CapacityDay getLastCapacityDay() {
        return table.peek();
    }
}
