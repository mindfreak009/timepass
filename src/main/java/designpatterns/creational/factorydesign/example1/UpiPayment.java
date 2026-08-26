package designpatterns.creational.factorydesign.example1;

public class UpiPayment implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Paid ::" + amount + " using UPI ");
    }
}
