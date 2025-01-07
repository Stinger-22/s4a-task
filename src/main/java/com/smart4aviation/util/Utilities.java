package com.smart4aviation.util;

/**
 * Utility class which contains only static methods for specific algorithms.
 */
public class Utilities {
    /**
     * <p>Find nearest number which is power of 2 and bigger than <code>number</code>.</p>
     * @param number for which find the nearest bigger power of 2.
     * @return nearest power of 2.
     */
    public static int nextPowerOfTwo(int number) {
        return 1 << (32 - Integer.numberOfLeadingZeros(number - 1));
    }
}
