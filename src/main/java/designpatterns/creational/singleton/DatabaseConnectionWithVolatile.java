package designpatterns.creational.singleton;

public class DatabaseConnectionWithVolatile {

    // Step 1. Volatile ensures visibility across threads
    private static volatile DatabaseConnectionWithVolatile instance;

    // Step 2: Private constructor
    private DatabaseConnectionWithVolatile(){
        System.out.println("Database connection established....");
    }

    // Step 3. Provide a public method to get the single instance
    public static DatabaseConnectionWithVolatile getInstance() {
        if(instance == null) {     // First check (without locking)
            synchronized (DatabaseConnectionWithVolatile.class) {
                if(instance == null) {    // Second check (with locking)
                    instance = new DatabaseConnectionWithVolatile();
                }
            }// First check, without locking
            instance = new DatabaseConnectionWithVolatile();       // Create it once.
        }
        // Return the same instance every time
        return instance;
    }

    // Step 4: Example method to simulate a query.
    public void executeQuery(String query) {
        System.out.println("Executing query:: " +query);
    }
}
