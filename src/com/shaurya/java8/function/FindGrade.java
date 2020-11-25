package com.shaurya.java8.function;

import java.util.*;
import java.util.function.Function;

public class FindGrade {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        addStudent(list);
        //find grade of student using function
        Function<Student,String> calculate = s->s.marks>=80?"A":(s.marks>=60?"B":"C");       
        System.out.printf("%20s\t%s\n","Name","Grade");
        for(Student s:list){
            System.out.printf("%20s\t%1s\n",s.name,calculate.apply(s));
        }

    }   
    static void addStudent(ArrayList<Student> list){
        list.add(new Student("Ram ",90));
        list.add(new Student("Koma ",80));
        list.add(new Student("Heena ",30));
        list.add(new Student("Meena ",20));
        list.add(new Student("Mno ",80));
        list.add(new Student("Suni ",50));
        list.add(new Student("PUnhari",60));
    }
}
class Student{
    String name;
    Integer marks;
    Student(String name,Integer marks){
        this.name=name;
        this.marks=marks;
    }
}
