package designpatterns.behavioral.observer.example1;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        stockMarket.register(new MobileDisplay());
        stockMarket.register(new WebDisplay());

        stockMarket.notifyAllObservers("TCS", 3895.70);
    }
}
