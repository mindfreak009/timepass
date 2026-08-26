package designpatterns.creational.factorydesign.example3;

public class WhatsAppNotification implements Notification{
    @Override
    public void send() {
        System.out.println("WhatsApp notification sent");
    }
}
