package designpatterns.creational.factorydesign.example1;

// Concrete products
public class CreditCardPayment implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Paid ::" + amount + " using Credit Card");
    }

}
