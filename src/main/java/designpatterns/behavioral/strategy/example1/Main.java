package designpatterns.behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        Checkout checkout = new Checkout(new FestivalDiscount());
        System.out.println(checkout.calculateFinalPrice(1000));

        Checkout checkout1 = new Checkout(new NewUserDiscount());
        System.out.println(checkout1.calculateFinalPrice(1000));
    }
}
