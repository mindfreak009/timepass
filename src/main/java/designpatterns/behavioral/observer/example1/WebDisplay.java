package designpatterns.behavioral.observer.example1;

public class WebDisplay implements Observer{

    @Override
    public void update(String stockName, double price) {
        System.out.println("Web Display - " + stockName + " updated to " + price);
    }
}
