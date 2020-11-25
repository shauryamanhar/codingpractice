package com.shaurya.java8.consumer;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ConsumerChaining {
    public static void main(String[] args) {
        //consumer do not have any return type;
        printMovie();
    }
    static void printMovie(){
        ArrayList<Movie> list = new ArrayList<>();
        list.add(new Movie("tom","cam","knight","HIT"));
        list.add(new Movie("mc","emit","inters","HIT"));
        list.add(new Movie("salman","katrin","ek the tiger","Ultra Flop"));
        Consumer<Movie> ready = m->System.out.println("Movie: "+m.toString()+" is ready to Release");
        Consumer<Movie> result = m->System.out.println("Movie: "+m.toString()+" Result: "+m.result);
        Consumer<Movie> print = m->System.out.println(m.toString());
        for(Movie m:list){
            ready.andThen(result).andThen(print).accept(m);;
        }
    }
    static class Movie{
        String actor;
        String actress;
        String name;
        String result;
        Movie(String actor,String actress,String name,String result){
            this.actor=actor;
            this.actress=actress;
            this.name=name;
            this.result=result;
        }
        @Override
        public String toString() {
            return name+","+actor+","+actress;
        }
    }
}
