package com.example.demo.util;

public class TimeUtil {

    private TimeUtil() {}

    public static boolean isValidTimeRange(String start, String end) {
        return start.compareTo(end) < 0;
    }
}
