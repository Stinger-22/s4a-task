package com.smart4aviation.util;

/**
 * Utility class which contains only static methods for specific algorithms.
 */
public class Utilities {
    /**
     * <p>Find nearest number which is power of 2 and bigger or equal to <code>number</code>.</p>
     * @param number accepts only positive numbers for which find the nearest bigger or equal power of 2.
     * @return nearest power of 2.
     * @throws IllegalArgumentException if <code>number</code> is less or equals to 0.
     */
    public static int nextPowerOfTwo(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be a positive integer");
        }
        if (number == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Next power of two is out of int range");
        }
        return 1 << (32 - Integer.numberOfLeadingZeros(number - 1));
    }
}
