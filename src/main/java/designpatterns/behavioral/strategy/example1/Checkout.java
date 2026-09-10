package designpatterns.behavioral.strategy.example1;

// Context
public class Checkout {

    private DiscountStrategy strategy;
    public Checkout(DiscountStrategy discountStrategy) {
        this.strategy = discountStrategy;
    }
    public double calculateFinalPrice(double price) {
        return strategy.applyDiscount(price);
    }
}
