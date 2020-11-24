package com.shaurya.java8.function;

import java.util.function.Function;

public class RemoveSpaceStringFunction {
    public static void main(String[] args) {
        Function<String,String> removeSpace = s->s.replace(" ", "");
        System.out.println(removeSpace.apply("Sh au rya Ma nh ar"));
    }
}
