package designpatterns.creational.factorydesign.example2;

public class EmployeeFactory {

    // get the Employee
    public static Employee getEmployee(String empType) {
        if(empType.trim().equalsIgnoreCase("JAVA DEVELOPER")) {
            return new JavaDeveloper();
        } else if(empType.trim().equalsIgnoreCase("ANDROID DEVELOPER")) {
            return new AndroidDeveloper();
        }
        return null;
    }
}
