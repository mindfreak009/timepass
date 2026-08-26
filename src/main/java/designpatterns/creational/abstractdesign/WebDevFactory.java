package designpatterns.creational.abstractdesign;

public class WebDevFactory extends  EmployeeAbstractFactory{
    @Override
    public Employee createEmployee() {
        return new WebDeveloper();
    }
}
