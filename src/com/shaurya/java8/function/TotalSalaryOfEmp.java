package com.shaurya.java8.function;

import java.util.ArrayList;
import java.util.function.Function;

public class TotalSalaryOfEmp {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        addEmp(list);
        System.out.println("Total Salary of Employee is:");
        Function<ArrayList<Employee>,Double> cal = l->{
            double t = 0;
            for(Employee e:l){
                t+=e.salary;
            }
            return t;
        };
        System.out.println(cal.apply(list));
    }   
    static void addEmp(ArrayList<Employee> l){
        l.add(new Employee("Shaurya", 20000D));
        l.add(new Employee("Leela", 22000D));
        l.add(new Employee("tinia", 12000D));
    } 
}

class Employee{
    String name;
    double salary;
    Employee(String n,double s){
        name=n;
        salary=s;
    }
}

