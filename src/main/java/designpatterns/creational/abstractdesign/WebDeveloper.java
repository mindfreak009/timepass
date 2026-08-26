package designpatterns.creational.abstractdesign;

public class WebDeveloper implements Employee {
    @Override
    public int salary() {
        return 40000;
    }

    @Override
    public String name() {
        return "I am Web Developer";
    }
}
