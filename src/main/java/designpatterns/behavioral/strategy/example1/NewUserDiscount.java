package designpatterns.behavioral.strategy.example1;

public class NewUserDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.8; // 20% off
    }
}
