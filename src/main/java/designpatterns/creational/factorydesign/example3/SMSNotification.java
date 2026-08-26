package designpatterns.creational.factorydesign.example3;

public class SMSNotification implements Notification{
    @Override
    public void send() {
        System.out.println("SMS Sent");
    }
}
