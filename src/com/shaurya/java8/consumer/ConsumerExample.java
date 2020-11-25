package com.shaurya.java8.consumer;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        //consumer do not have any return type;
        Consumer<String> consumer = s->System.out.println(s);
        consumer.accept("Shaurya");
        consumer.accept("Manhar");
        System.out.println("===========");
        printMovie();
    }
    static void printMovie(){
        ArrayList<Movie> list = new ArrayList<>();
        list.add(new Movie("tom","cam","knight"));
        list.add(new Movie("mc","emit","inters"));
        Consumer<Movie> c = m->System.out.println(m.toString());
        for(Movie m:list){
            c.accept(m);
        }
    }
    static class Movie{
        String actor;
        String actress;
        String name;
        Movie(String actor,String actress,String name){
            this.actor=actor;
            this.actress=actress;
            this.name=name;
        }
        @Override
        public String toString() {
            return name+","+actor+","+actress;
        }
    }
}
