package com.shaurya.java8.supplier;

import java.util.function.Supplier;

public class GenerateOTP {
    public static void main(String[] args) {
        Supplier<String> opt = ()->{
            int n = (int)(Math.random()*1000_000);
            return n+"";
        }; 
        System.out.println("OTP is "+opt.get());
    }
}
