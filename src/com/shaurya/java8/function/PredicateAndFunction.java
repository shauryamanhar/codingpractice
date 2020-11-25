package com.shaurya.java8.function;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateAndFunction {
    static class Employee{
        String name;
        double salary;
        Employee(String n,double s){
            name=n;
            salary=s;
        }
        @Override
        public String toString() {
            return name+","+salary;
        }
    }
    public static void main(String[] args) {
        //increment salary of emp<=30000 by 5000
        ArrayList<Employee> l = new ArrayList<>();
        addEmp(l);
        System.out.println("Previous Salaray");
        System.out.println(l);
        Predicate<Employee> rule = e -> e.salary<=30_000;
        Function<Employee,Employee> update = e ->{
            e.salary+=5000;
            return e;
        };
        ArrayList<Employee> l2 = new ArrayList<>();
        for(Employee e:l){
            if(rule.test(e)){
                update.apply(e);
                l2.add(e);
            }
        }
        System.out.println("Updated Salary");
        System.out.println(l2);
    }
    static void addEmp(ArrayList<Employee> l){
        l.add(new Employee("Shaurya", 50000D));
        l.add(new Employee("Leela", 22000D));
        l.add(new Employee("tinia", 12000D));
    } 
}

