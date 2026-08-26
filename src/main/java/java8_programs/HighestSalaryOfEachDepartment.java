package java8_programs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int sal;
    private String dept;

    public Employee(String name, int sal, String dept) {
        this.name = name;
        this.sal = sal;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public int getSal() {
        return sal;
    }

    public String getDept() {
        return dept;
    }

}
public class HighestSalaryOfEachDepartment {
    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Lenovo", 25000, "IT"));
        emp.add(new Employee("Dell", 45000, "Finance"));
        emp.add(new Employee("Lenovo", 35000, "IT"));
        emp.add(new Employee("Peter", 93000, "Admin"));
        emp.add(new Employee("HP", 7500, "IT"));

        Map<String, Integer> collect = emp.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Employee::getSal)),
                                optional -> optional.get().getSal())));

        System.out.println(collect);
    }
}
