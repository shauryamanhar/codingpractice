package interview.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.averagingInt;;

// https://github.com/javaTechiess/org/blob/main/src/javatechies/org/stream/EmployeeStreamDemo.java
public class EmployeeStreamDemo {
	static List<Employee> employeeList = new ArrayList<Employee>();

	public static void main(String[] args) {
		init();
		// Query 1 : How many male and female employees are there in the organization?
//		query1();

		// Query 2 : Print the name of all departments in the organization?
//		query2();

		// Query 3 : What is the average age of male and female employees?
//		query3();

		// Query 4 : Get the details of highest paid employee in the organization?
//		query4();

		// Query 5 : Get the names of all employees who have joined after 2015?
//		query5();

		// Query 6 : Count the number of employees in each department?
//		query6();

		// Query 7 : What is the average salary of each department?
		// query7();

		// Query 8 : Get the details of youngest male employee in the product
		// development department?
//		query8();
		query16();

	}

	static void query1() {
		System.out.println("Query 1 : How many male and female employees are there in the organization?");
		Map<String, Long> result = employeeList.stream().collect(groupingBy(Employee::getGender, counting()));
		System.out.println(result);
	}

	static void query2() {
		System.out.println("Query 2 : Print the name of all departments in the organization?");
		// Set<String> result =
		// employeeList.stream().map(x->x.getDepartment()).collect(toSet());
		// List<String> result =
		// employeeList.stream().map(Employee::getDepartment).distinct().collect(toList());
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
	}

	static void query3() {
		System.out.println("Query 3 : What is the average age of male and female employees?");
		Double avgAge = employeeList.stream().collect(Collectors.averagingInt(Employee::getAge));
		System.out.println("Avg age (male+female) " + avgAge);

		Map<String, Double> ageMap = employeeList.stream()
				.collect(groupingBy(Employee::getGender, averagingInt(Employee::getAge)));
		System.out.println(ageMap);
	}

	static void query4() {
		System.out.println("Query 4 : Get the details of highest paid employee in the organization?");
		Comparator<Employee> comp = (a, b) -> (int) (a.getSalary() - b.getSalary());
		Optional<Employee> emp = employeeList.stream().collect(Collectors.maxBy(comp));
		System.out.println(emp);

		emp = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println(emp);
	}

	static void query5() {
		System.out.println("Query 5 : Get the names of all employees who have joined after 2015?");
		List<Employee> emp = employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).collect(toList());
		System.out.println(emp);
		employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName)
				.forEach(System.out::println);
		;
	}

	static void query16() {
		System.out.println(employeeList.stream().filter(x -> x.getGender().equals("Male"))
				.collect(Collectors.maxBy((a, b) -> (int) (a.getSalary() - b.getSalary()))));
	}

	// Query 6 : Count the number of employees in each department?
	static void query6() {
		System.out.println("Query 6 : Count the number of employees in each department?");
		Map<String, Long> map = employeeList.stream().collect(groupingBy(Employee::getDepartment, counting()));
		System.out.println(map);
	}

	// Query 7 : What is the average salary of each department?
	static void query7() {
		System.out.println("Query 7 : What is the average salary of each department?");
		Map<String, Double> avg = employeeList.stream()
				.collect(groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		for (String key : avg.keySet()) {
			System.out.println(key + "=>" + avg.get(key));
		}
	}

	// Query 8 : Get the details of youngest male employee in the product
	// development department?
	static void query8() {
		System.out
				.println("Query 8 : Get the details of youngest male employee in the product development department?");
		Optional<Employee> young = employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge)).findFirst();
		// yongest on all System.out.println(young);

		// using sorting
		young = employeeList.stream()
				.filter(e -> e.getGender().equals("Male") && e.getDepartment().equals("Product Development"))
				.sorted(Comparator.comparingInt(Employee::getAge)).findFirst();
		System.out.println(young);

		// using min function
		young = employeeList.stream()
				.filter(e -> e.getGender().equals("Male") && e.getDepartment().equals("Product Development"))
				.min(Comparator.comparingInt(Employee::getAge));
		System.out.println(young);
	}

	static void init() {
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
	}
}

class Employee {
	int id;
	String name;
	int age;
	String gender;
	String department;
	int yearOfJoining;
	double salary;

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getDepartment() {
		return department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
				+ department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary + "";
	}
}
