package designpatterns.creational.singleton;

// Single class for Database connection
public class DatabaseConnection {

    // Step 1. Create a private static instance variable
    private static DatabaseConnection instance;

    // Step 2: Make the constructor private, so that no one can create it directly
    private DatabaseConnection(){
        System.out.println("Database connection initialized");
    }

    // Step 3. Provide a public method to get the single instance
    public static DatabaseConnection getInstance() {
        if(instance == null) {                         // If no instance exists
            instance = new DatabaseConnection();       // Create it once.
        }
        // Return the same instance every time
        return instance;
    }

    // Step 4: Example method to simulate a query.
    public void executeQuery(String query) {
        System.out.println("Executing query:: " +query);
    }
}
