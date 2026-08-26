package designpatterns.creational.abstractdesign;

public class AndroidDeveloper implements Employee {
    @Override
    public int salary() {
        return 5000;
    }

    @Override
    public String name() {
        return "I am Android Developer";
    }
}
