package designpatterns.behavioral.observer.example1;

public class MobileDisplay implements Observer{

    @Override
    public void update(String stockName, double price) {
        System.out.println("Mobile Display - " + stockName + " updated to " + price);
    }
}
