package interview_ques.servicebased.altimetrik;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Find second highest salary of the employee

public class Employee1 {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;

    public Employee1(int id, String name, String department, double salary, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    // Getters
    public int getId()              { return id; }
    public String getName()         { return name; }
    public String getDepartment()   { return department; }
    public double getSalary()       { return salary; }
    public int getAge()             { return age; }

    @Override
    public String toString() {
        return name + "(" + department + ", " + salary + ")";
    }

    public static void main(String[] args) {
        List<Employee1> employees = Arrays.asList(
                new Employee1(1, "Alice",   "Engineering", 95000, 30),
                new Employee1(2, "Bob",     "Engineering", 85000, 28),
                new Employee1(3, "Charlie", "HR",          60000, 35),
                new Employee1(4, "Diana",   "HR",          62000, 32),
                new Employee1(5, "Eve",     "Finance",     75000, 40),
                new Employee1(6, "Frank",   "Finance",     80000, 38),
                new Employee1(7, "Grace",   "Engineering", 90000, 27)
        );

        Optional<Double> first =
                employees.stream()
                .map(Employee1::getSalary)
                .sorted((a,b) -> Double.compare(b,a))
                .skip(1)
                .findFirst();

        System.out.println(first.orElse(null));
    }
}
