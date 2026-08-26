package designpatterns.creational.abstractdesign;

public class AbstractDesignMain {
    public static void main(String[] args) {

        Employee emp1 = EmployeeFactory.getEmployee(new AndroidDevFactory());
        System.out.println(emp1.name());

        Employee emp2 = EmployeeFactory.getEmployee(new WebDevFactory());
        System.out.println(emp2.name());

    }
}
