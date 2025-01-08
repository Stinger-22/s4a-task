package com.smart4aviation;

import com.smart4aviation.airport.Airport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class App {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Airport airport = loadStartupData(scanner);
            airport.run();
        } catch (RuntimeException e) {
            logger.error("Couldn't read number of routes, number of queries and plane capacities");
        }

        scanner.close();
    }

    private static Airport loadStartupData(Scanner scanner) {
        int numberOfRoutes = scanner.nextInt();
        int numberOfQueries = scanner.nextInt();
        int[] planeCapacities = new int[numberOfRoutes];
        for (int i = 0; i < numberOfRoutes; i++) {
            planeCapacities[i] = scanner.nextInt();
        }
        logger.info("Received number of routes, number of queries and plane capacities");
        return new Airport(scanner, planeCapacities, numberOfQueries);
    }
}
