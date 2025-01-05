package com.smart4aviation;

import com.smart4aviation.queries.*;

import java.util.Scanner;

public class QueryParser {
    private final Scanner scanner;

    public QueryParser(Scanner scanner) {
        this.scanner = scanner;
    }

    // Might use optional
    public Query next() {
        if (!scanner.hasNext()) {
            return null;
        }
        char queryType = scanner.next().charAt(0);
        switch (queryType) {
            case 'P': {
                int planeId = scanner.nextInt();
                int newCapacity = scanner.nextInt();
                long day = scanner.nextInt();
                return new ChangePlaneCapacityOnDay(planeId, newCapacity, day);
            }
            case 'C': {
                int planeId = scanner.nextInt();
                long day = scanner.nextInt();
                return new RemovePlaneOnDay(planeId, day);
            }
            case 'A': {
                int planeId = scanner.nextInt();
                int newCapacity = scanner.nextInt();
                long day = scanner.nextInt();
                return new AssignPlaneChangeCapacityOnDay(planeId, newCapacity, day);
            }
            case 'Q': {
                int firstRoute = scanner.nextInt();
                int lastRoute = scanner.nextInt();
                long day = scanner.nextInt();
                return new TotalCapacityByPlanesActiveOnDay(firstRoute, lastRoute, day);
            }
            default:
                throw new IllegalArgumentException("Invalid query type");
        }
    }
}
