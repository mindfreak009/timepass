package designpatterns.creational.singleton;

public class DatabaseConnectionMain {
    public static void main(String[] args) {
        // Get the first instance
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.executeQuery("select * from users");

        // Try to get another instance
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        db2.executeQuery("insert into users values('Lenovo', 3)");

        // Both db1 and db2 point to the same instance(object)
        System.out.println(db1 == db2);    // Output: true
    }
}
