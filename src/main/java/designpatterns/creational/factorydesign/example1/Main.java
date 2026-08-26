package designpatterns.creational.factorydesign.example1;

public class Main {
    public static void main(String[] args) {
        Payment payment = PaymentFactory.getPaymentMethod("credit");
        payment.pay(3000);
    }
}
