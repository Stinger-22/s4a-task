package com.smart4aviation;

import com.smart4aviation.airport.Airport;
import com.smart4aviation.airport.QueryHandler;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Airport airport = loadStartupData(scanner);
        airport.setQueryHandler(new QueryHandler(scanner));
        airport.run();

        scanner.close();
    }

    private static Airport loadStartupData(Scanner scanner) {
        int numberOfRoutes = scanner.nextInt();
        int numberOfQueries = scanner.nextInt();
        int[] planeCapacities = new int[numberOfRoutes];
        for (int i = 0; i < numberOfRoutes; i++) {
            planeCapacities[i] = scanner.nextInt();
        }
        return new Airport(planeCapacities, numberOfQueries);
    }
}
