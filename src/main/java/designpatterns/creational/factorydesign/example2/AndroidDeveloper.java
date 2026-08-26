package designpatterns.creational.factorydesign.example2;

public class AndroidDeveloper implements Employee {

    @Override
    public int salary() {
        System.out.println("Getting Android Developer salary :::: ");
        return 50000;
    }
}
