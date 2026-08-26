package java8_programs.java17;


import java.util.ArrayList;
import java.util.List;

record Employee(int id, String name, double salary) {}

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Henry", 200.10));
        employeeList.add(new Employee(102, "Peter", 525.17));
        employeeList.add(new Employee(103, "Helenski", 993.45));
        employeeList.add(new Employee(104, "Mary", 1660.30));

        System.out.println(employeeList);

        /** Fetch first employee record **/
        Employee employee = employeeList.get(0);
        System.out.println(employee);

        /** Access fields **/
        /** In records, getters are named exactly like field names: **/
        System.out.println(employee.id());
        System.out.println(employee.name());
        System.out.println(employee.salary());

        /** Safe Way to Fetch First Record **/
        if (!employeeList.isEmpty()) {
            Employee firstEmployee = employeeList.get(0);
            System.out.println(firstEmployee.name());
        }

    }
}
