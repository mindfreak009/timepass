package designpatterns.creational.singleton.enumforsingleton;

public class Main {
    public static void main(String[] args) {

        DatabaseConnectionManager obj1 =
                DatabaseConnectionManager.INSTANCE;

        DatabaseConnectionManager obj2 =
                DatabaseConnectionManager.INSTANCE;

        System.out.println(obj1 == obj2);
        System.out.println(obj1.getConnectionString());
        System.out.println(obj2.getConnectionString());
        System.out.println(obj2.connect());
        System.out.println(obj1.connect());
    }
}
