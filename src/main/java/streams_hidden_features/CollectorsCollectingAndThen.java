package streams_hidden_features;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class CollectorsCollectingAndThen {
    public static void main(String[] args) {

    List<Employee> employeeList = Arrays.asList(
            new Employee("Patrick", 50000),
            new Employee("Natthews", 60000),
            new Employee("Perry", 15000),
            new Employee("Rohit", 20000),
            new Employee("Virat", 80000),
            new Employee("Hardik Pandya", 80000)
    );

    // calculate avg salary and round up to nearest integer
      Long employeeResult =   employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.averagingDouble(Double::doubleValue),
                        avg -> Math.round(avg)
                ));

        Employee maxSalaryEmployee = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getName)))
                .orElseThrow(() -> new RuntimeException("No employeees found"));

        System.out.println(maxSalaryEmployee);
        System.out.println("employee result :: " + employeeResult);

        employeeList.stream()
                .collect(Collectors.groupingBy(x->x.getSalary()))
                .entrySet().forEach(x->{
                        System.out.println(x.getKey()+" "+x.getValue());
        });

        Map<Employee, List<Employee>> collect = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .collect(Collectors.groupingBy(Employee::getName, LinkedHashMap::new, Collectors.toList()))
                .values().stream()
                .collect(toMap(l -> l.get(0), Function.identity()));

        System.out.println(collect);

        Optional<Employee> first = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .findFirst();

        System.out.println(first);

    }
}

class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}