package com.example.web_api_json.logic;

import com.example.web_api_json.service.ClassMessages;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SolvatorImpl implements ISolvator {
    @Override
    public ClassMessages.OutputMessage solve(ClassMessages.InputMessage input) {
        LocalDateTime fromDate = input.date1;
        LocalDateTime toDate = input.date2;
        String typeResult = input.typeResult;
        String result = "";

        // checking the correctness of entering the start and end dates
//        if(toDate.isBefore(fromDate)){
//            LocalDateTime temp = toDate;
//            toDate = fromDate;
//            fromDate = temp;
//        }

        switch (typeResult) {
            case "sec" -> result = String.valueOf(ChronoUnit.SECONDS.between(fromDate, toDate));
            case "min" -> result = String.valueOf(ChronoUnit.MINUTES.between(fromDate, toDate));
            case "hour" -> result = String.valueOf(ChronoUnit.HOURS.between(fromDate, toDate));
            case "time" -> {
                LocalDateTime tempDateTime = LocalDateTime.from(fromDate);
                long hours = tempDateTime.until(toDate, ChronoUnit.HOURS);
                tempDateTime = tempDateTime.plusHours(hours);
                long minutes = tempDateTime.until(toDate, ChronoUnit.MINUTES);
                tempDateTime = tempDateTime.plusMinutes(minutes);
                long seconds = tempDateTime.until(toDate, ChronoUnit.SECONDS);
                result = "hh:mm:ss - " + hours + ":" + minutes + ":" + seconds + ".";
            }
            case "full" -> {
                LocalDateTime tempDateTime = LocalDateTime.from(fromDate);
                long years = tempDateTime.until(toDate, ChronoUnit.YEARS);
                tempDateTime = tempDateTime.plusYears(years);
                long months = tempDateTime.until(toDate, ChronoUnit.MONTHS);
                tempDateTime = tempDateTime.plusMonths(months);
                long days = tempDateTime.until(toDate, ChronoUnit.DAYS);
                tempDateTime = tempDateTime.plusDays(days);
                long hours = tempDateTime.until(toDate, ChronoUnit.HOURS);
                tempDateTime = tempDateTime.plusHours(hours);
                long minutes = tempDateTime.until(toDate, ChronoUnit.MINUTES);
                tempDateTime = tempDateTime.plusMinutes(minutes);
                long seconds = tempDateTime.until(toDate, ChronoUnit.SECONDS);
                result = years + " years " + months + " months " + days + " days " +
                        hours + " hours " + minutes + " minutes " + seconds + " seconds.";
            }
        }

        return new ClassMessages.OutputMessage(fromDate, toDate, typeResult, result);
    }
}
