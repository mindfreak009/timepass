package designpatterns.behavioral.observer.example2;



public class Subscriber implements Observer{
    @Override
    public void notified() {
        System.out.println("new video uploaded notification ::: ");
    }
}
