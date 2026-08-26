package interview_ques.coforge;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
        // Sample list of employees
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Alice", "HR", 12000),
                new Employee(2, "Bob", "IT", 9500),
                new Employee(3, "Charlie", "Finance", 15000),
                new Employee(4, "David", "IT", 20000),
                new Employee(5, "Eve", "HR", 8000)
        );

        List<Employee> finalResult = employeeList.stream()
                .filter(e -> e.getSalary() > 10000)
                .peek(e -> e.setName(e.getName().toUpperCase()))
                .collect(Collectors.toList());

        System.out.println(finalResult);
        System.out.println("employeeList :: " + employeeList);

    }
}
