package designpatterns.creational.factorydesign.example2;

public class JavaDeveloper implements Employee {
    @Override
    public int salary() {
        System.out.println("Getting Java Developer salary ::: ");
        return 75000;
    }
}
