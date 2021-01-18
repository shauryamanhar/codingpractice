package com.shaurya.java8.datetimeperiod;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneIdIntroduction {
    public static void main(String[] args) {
        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println(defaultZone);//Asia/Kolkata

        //custom zone id
        ZoneId usaZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime usaDateTime = ZonedDateTime.now(usaZone);
        System.out.println("Time in USA:");
        System.out.println(usaDateTime);//time in USA now
    }
}
