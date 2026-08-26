package designpatterns.creational.prototype;

// The concept is to copy an existing object rather than creating a new instance from scratch,
//  since creating new object is costly.
// This approach saves costly resources and time, especailly when object creation is a heavy process.

public class PrototypeDesignPattern {
    public static void main(String[] args) {

        System.out.println("Creating objects using Prototype design pattern :");
        NetworkConnection connection = new NetworkConnection();
        connection.setIp("192.158.44.12");
        connection.loadVeryImportantData();

        System.out.println(connection);
        connection.clone();

        NetworkConnection connection2 = connection.clone();;
        System.out.println(connection2);

    }
}
