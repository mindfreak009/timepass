package designpatterns.creational.factorydesign.example3;

public class Main {
    public static void main(String[] args) {
        NotificationFactory.register(
                "EMAIL",
                EmailNotification::new
        );

        NotificationFactory.register(
                "SMS",
                SMSNotification::new
        );

        NotificationFactory.register(
                "WhatsApp",
                WhatsAppNotification::new
        );

        Notification n1 = NotificationFactory.create("email");
        Notification n2 = NotificationFactory.create("sms");
        Notification n3 = NotificationFactory.create("whatsapp");

        n1.send();
        n2.send();
        n3.send();
    }
   }
