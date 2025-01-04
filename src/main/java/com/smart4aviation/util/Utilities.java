package com.smart4aviation.util;

public class Utilities {
    public static int nextPowerOfTwo(int number) {
        return 1 << (32 - Integer.numberOfLeadingZeros(number - 1));
    }
}
