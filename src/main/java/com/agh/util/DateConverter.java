package com.agh.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConverter {

    public static LocalDate toDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public static LocalDateTime toDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

    public static LocalDateTime toDateTimeNoHour(String dateTime) {
        return LocalDateTime.parse(dateTime + " 00:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}