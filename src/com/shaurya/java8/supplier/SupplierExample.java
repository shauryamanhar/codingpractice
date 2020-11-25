package com.shaurya.java8.supplier;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        //supplier dont have input it just return something
        Supplier<Date> s = ()->new Date();
        System.out.println(s.get());

        Supplier<String> random = ()->{
            String r[] = {"Sunny","Cold","Rainy","Summer"};
            int n = (int)(Math.random()*4);
            return r[n];
        };
        System.out.println(random.get());
    }
}
