package interview_ques.iris;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int employeeId;
    String name;
    int sal;
    String dept;

    public Employee(int employeeId, String name, int sal, String dept) {
        this.employeeId = employeeId;
        this.name = name;
        this.sal = sal;
        this.dept = dept;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                ", dept='" + dept + '\'' +
                '}';
    }
}

//   find dept having max salary
public class FindDeptWithMaxSalary {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();

        Employee emp1 = new Employee(1, "Alex", 2000, "Finance");
        Employee emp2 = new Employee(2, "Donald", 52000, "Marketing");
        Employee emp3 = new Employee(3, "Henry", 7000, "Sales");
        Employee emp4 = new Employee(4, "Amar", 5000, "R&D");
        Employee emp5 = new Employee(5, "Perry", 17000, "IT");
        Employee emp6 = new Employee(6, "Elyssa", 21000, "Admin");
        Employee emp7 = new Employee(7, "Alyssa", 15000, "HR");

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        list.add(emp5);
        list.add(emp6);
        list.add(emp7);

        // Step 1: Group employees by department and calculate total salary per department
        Map<String, Integer> groupByDept =
                list.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.summingInt(Employee::getSal)));

        // Step 2: Find the department with the maximum salary
        Optional<Map.Entry<String, Integer>> maxSalaryDept =
                groupByDept.
                        entrySet().
                        stream().
                        max(Map.Entry.comparingByValue());

        // Step 3: Print the department with the highest salary
        maxSalaryDept.ifPresent(entry -> {
            System.out.println("Department with highest salary : " +entry.getKey());
            System.out.println("Total salary : " +entry.getValue());

        });




        // find dept having max salary
        // select e1.dept, e1.sal from employee e1
        //  join employee e2
        //  ON e1.id = e2.id
        //  GROUP BY dept
        //  where sal < (select max(sal) from e1)

        //.sorted(Comparator.comparing(Employee::getDept))
                //.filter(i -> )

    }
}
