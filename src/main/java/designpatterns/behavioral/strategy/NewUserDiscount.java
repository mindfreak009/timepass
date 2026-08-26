package designpatterns.behavioral.strategy;

public class NewUserDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double price) {
        return price * 0.8; // 20% off
    }
}
