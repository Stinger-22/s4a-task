package com.smart4aviation.airport;

import com.smart4aviation.queries.*;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class TestQueryParser {
    @Test
    void parseP() {
        Scanner scanner = new Scanner("P 1 3 5");
        QueryParser queryParser = new QueryParser(scanner);
        Query query = queryParser.next();
        assertInstanceOf(ChangePlaneCapacityOnDay.class, query);
    }

    @Test
    void parseA() {
        Scanner scanner = new Scanner("A 3 2 1");
        QueryParser queryParser = new QueryParser(scanner);
        Query query = queryParser.next();
        assertInstanceOf(AssignPlaneChangeCapacityOnDay.class, query);
    }

    @Test
    void parseQ() {
        Scanner scanner = new Scanner("Q 0 4 5");
        QueryParser queryParser = new QueryParser(scanner);
        Query query = queryParser.next();
        assertInstanceOf(TotalCapacityByPlanesActiveOnDay.class, query);
    }

    @Test
    void parseC() {
        Scanner scanner = new Scanner("C 1 2");
        QueryParser queryParser = new QueryParser(scanner);
        Query query = queryParser.next();
        assertInstanceOf(RemovePlaneOnDay.class, query);
    }

    @Test
    void parseUnknown() {
        Scanner scanner = new Scanner("L 2 9");
        QueryParser queryParser = new QueryParser(scanner);
        assertThrows(IllegalArgumentException.class, queryParser::next);
    }
}
