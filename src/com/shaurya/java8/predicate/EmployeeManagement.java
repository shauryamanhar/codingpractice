package com.shaurya.java8.predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class EmployeeManagement {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        addEmployee(list);
        //print all the Manager
        Predicate<Employee> filter = (emp)->emp.designation.equalsIgnoreCase("Manager");
        for(Employee emp:list){
            if(filter.test(emp)){
                System.out.println(emp.toString());
            }
        }
    }//main
    public static void addEmployee(ArrayList<Employee> list){
        list.add(new Employee("Durga", "Engineer", 30_000D, "Hydrabad"));
        list.add(new Employee("Fatima", "Staff Engineer", 56_000D, "Mumbai"));
        list.add(new Employee("Sheetal", "Manager", 1_56_000D, "Delhi"));
        list.add(new Employee("Modi", "Manager", 1_30_000D, "Chhattishgarh"));
    }
}

class Employee{
    String name;
    String designation;
    Double salary;
    String city;
    Employee(String name,String designation,Double salary,String city){
        this.name=name;
        this.designation=designation;
        this.salary=salary;
        this.city=city;
    }

    @Override
    public String toString() {
        return String.format("{%s,%s,%.2f,%s)", name,designation,salary,city);
    }
}

