package com.shaurya.java8.function;

import java.util.function.Function;

public class FunctionChain {
    public static void main(String[] args) {
        int n=3;
        Function<Integer,Integer> add = i->i+2;
        Function<Integer,Integer> mul = i -> i*5;
        System.out.println(add.andThen(mul).apply(n));//f1->f2
        System.out.println(add.compose(mul).apply(n));//f2->f1
    }
}
