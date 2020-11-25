package com.shaurya.java8.consumer;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateFunctionConsumer {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        addStudent(list);
        //rule marks>=60
        Predicate<Student> rule = s->s.marks>=60;

        //calculating grade
        Function<Student,String> cal = s->{
            int m = s.marks;
            if(m>=90){
                return "A";
            }else if(m>=75){
                return "B";
            }else if(m>=60){
                return "C";
            }else if(m>=35){
                return "D";
            }else{
                return "F";
            }
        };
        System.out.println("List Student having marks greater than 60");
        //print the student
        Consumer<Student> print = s->System.out.println(s.toString());
        for(Student s:list){
            s.grade = cal.apply(s);
            if(rule.test(s)){
                print.accept(s);
            }
        }
    }
    static void addStudent(ArrayList<Student> l){
        l.add(new Student("Ram",60));
        l.add(new Student("Seema",78));
        l.add(new Student("Sun",90)); 
        l.add(new Student("Lucy",35));
        l.add(new Student("Mona",89));           
    }
    static class Student{
        String name;
        String grade;
        int marks;
        Student(String n,int m){
            name=n;
            marks=m;
            grade="UNDEFINE";
        }
        @Override
        public String toString() {
            return name+"\t"+grade;
        }
    }
}
