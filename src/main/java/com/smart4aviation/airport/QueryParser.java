package com.smart4aviation.airport;

import com.smart4aviation.queries.*;

import java.util.Scanner;

/**
 * <p>Instances of this class are responsible for reading input queries using the given scanner.</p>
 */
public class QueryParser {
    private final Scanner scanner;

    /**
     * <p>Creates parser which reads from the given scanner.</p>
     * @param scanner from which to read the input.
     */
    public QueryParser(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * <p>Check whether there are any input to process.</p>
     * @return true if the input is not empty.
     * @see Scanner#hasNext()
     */
    public boolean hasNext() {
        return scanner.hasNext();
    }

    /**
     * <p>Parse query in a text form.</p>
     * <p>If there is no next query, returns null.</p>
     * @return parsed query or null if there was no input.
     * @throws IllegalArgumentException if parser received unknown Query letter.
     */
    // Might be better to return Optional<Query>
    public Query next() {
        if (!hasNext()) {
            return null;
        }
        char queryType = scanner.next().charAt(0);
        switch (queryType) {
            case 'P': {
                int planeId = scanner.nextInt();
                int newCapacity = scanner.nextInt();
                long day = scanner.nextInt();
                return new ChangePlaneCapacityOnDay(planeId - 1, newCapacity, day);
            }
            case 'C': {
                int planeId = scanner.nextInt();
                long day = scanner.nextInt();
                return new RemovePlaneOnDay(planeId - 1, day);
            }
            case 'A': {
                int planeId = scanner.nextInt();
                int newCapacity = scanner.nextInt();
                long day = scanner.nextInt();
                return new AssignPlaneChangeCapacityOnDay(planeId - 1, newCapacity, day);
            }
            case 'Q': {
                int firstRoute = scanner.nextInt();
                int lastRoute = scanner.nextInt();
                long day = scanner.nextInt();
                return new TotalCapacityByPlanesActiveOnDay(firstRoute - 1, lastRoute - 1, day);
            }
            default:
                throw new IllegalArgumentException("Invalid query type");
        }
    }
}
