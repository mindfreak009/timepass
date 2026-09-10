package designpatterns.behavioral.strategy;

public class FestivalDiscount implements DiscountStrategy{

    @Override
    public double applyDiscount(double price) {
        return price * 0.9; // 10% off
    }
}
