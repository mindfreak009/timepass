package designpatterns.creational.factorydesign.example2;

//  Factory Method Design Pattern define an interface for creating an object, but let subclass decide which class to instantiate.
//  Factory Method lets a class defer instantiation to subclass.

//  Then we create factory class which takes responsibility of creating object of class based on input.

/*     ADVANTAGES OF FACTORY DESIGN PATTERN   */
     //  1.  Focus on  creating object for Interface rather than implementation.
     //  2.  Loose coupling, more robust code.

public class FactoryDesignMain {
    public static void main(String[] args) {
            // Employee emp = new

        Employee employee = EmployeeFactory.getEmployee("android developer");
        System.out.println(" Salary of Android Developer ::: " + employee.salary());

        Employee employee2 = EmployeeFactory.getEmployee("java developer");
        System.out.println(" Salary of Java Developer ::: " + employee2.salary());


    }
}
