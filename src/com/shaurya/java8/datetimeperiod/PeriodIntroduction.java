package com.shaurya.java8.datetimeperiod;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

//calculate age using java.time or joda api
public class PeriodIntroduction {
    public static void main(String[] args) {
        LocalDate bday = LocalDate.of(1882, Month.APRIL,19);
        LocalDate today = LocalDate.now();
        Period period = Period.between(bday, today);
        System.out.println(period);
        System.out.printf("Your age is %d year %d months and %d days\n",
            period.getYears(),period.getMonths(),period.getDays());

    }
}
