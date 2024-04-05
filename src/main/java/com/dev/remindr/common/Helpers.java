package com.dev.remindr.common;

import com.dev.remindr.Event.Event;

import java.util.Date;

public class Helpers {
    public static Long generateHash(String data) {
        return (long) data.hashCode();
    }

    public static Date getDifferenceDate(Event event) {
        long seconds = event.getDueDate().getTime() / 1000;
        int totalSeconds = event.getUnit().toSeconds(event.getUnits());
        seconds -= totalSeconds;
        return new Date(seconds * 1000);
    }
}
