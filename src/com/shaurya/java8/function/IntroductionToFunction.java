package com.shaurya.java8.function;

import java.util.function.Function;

public class IntroductionToFunction {
    public static void main(String[] args) {
      //arg1 is input type and arg2 is return type
      Function<String,Integer> fuction = s->s.length();
      System.out.println("Example of funciton interface");
      System.out.println("length of String "+fuction.apply("Hello World"));

      //square of number
      Function<Integer,Integer> squareFunction = i->i*i;
      int i=5;
      System.out.println("Square of number "+i+" := "+squareFunction.apply(i));

    }
}
