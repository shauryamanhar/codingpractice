package com.shaurya.java8.predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class EmployeeManagement {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        addEmployee(list);
        Predicate<Employee> managerFilter = (emp)->emp.designation.equalsIgnoreCase("Manager");
        
        //print all the Manager
        System.out.println("List of Manager");
        for(Employee emp:list){
            if(managerFilter.test(emp)){
                System.out.println(emp.toString());
            }
        }
        //print all manager who have salary>=1_50_000 and who live Delhi
        Predicate<Employee> salaryFilter = (emp)->emp.salary>=1_50_000D;
        Predicate<Employee> cityFilter = (emp)->emp.city.equalsIgnoreCase("Delhi");
        System.out.println("\nprint all manager who have salary>=1_50_000 and who live Delhi");
        for(Employee emp:list){
            if(managerFilter.and(salaryFilter).and(cityFilter).test(emp)){
                System.out.println(emp.toString());
            }
        }


        //find the CEO and using static method isEqual 
        System.out.println("Testing for CEO using isEqual method");
        Predicate<Employee> isCEO = Predicate.isEqual(new Employee("Shaurya", "CEO", 2_30_000D, "Chhattishgarh"));
        Employee e1 = new Employee("Shaurya", "CEO", 2_30_000D, "Chhattishgarh");
        Employee e2 = new Employee("Manhar", "CTO", 2_32_000D, "Delhi");
        //need to override equals method for this otherwise it going to call equals 
        System.out.println(isCEO.test(e1));
        System.out.println(isCEO.test(e2));
    }//main
    public static void addEmployee(ArrayList<Employee> list){
        list.add(new Employee("Durga", "Engineer", 30_000D, "Hydrabad"));
        list.add(new Employee("Fatima", "Staff Engineer", 56_000D, "Mumbai"));
        list.add(new Employee("Sheetal", "Manager", 1_56_000D, "Delhi"));
        list.add(new Employee("Modi", "Manager", 1_30_000D, "Chhattishgarh"));
        list.add(new Employee("Shaurya", "CEO", 2_30_000D, "Chhattishgarh"));
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
    public boolean equals(Object o) {
        Employee e = (Employee)o;
        if(name.equals(e.name) && designation.equalsIgnoreCase(e.designation)){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return String.format("{%s,%s,%.2f,%s)", name,designation,salary,city);
    }
}

