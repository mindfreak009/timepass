package designpatterns.creational.factorydesign.example1;

public class PaymentFactory {
    public static Payment getPaymentMethod(String type) {
        if("UPI".equalsIgnoreCase(type)) {
            return new UpiPayment();
        } else if ("CREDIT".equalsIgnoreCase(type)) {
            return new CreditCardPayment();
        }
        throw new IllegalArgumentException("Unknown Payment Type");
    }
}
