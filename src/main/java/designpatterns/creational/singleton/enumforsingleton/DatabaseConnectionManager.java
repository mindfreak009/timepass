package designpatterns.creational.singleton.enumforsingleton;

// The below enum is conceptually similar to:

// public final class DatabaseConnectionManager {

//    public static final DatabaseConnectionManager INSTANCE =
//        new DatabaseConnectionManager();

//    private DatabaseConnectionManager() {
//    }
//
//    // fields and methods...
//}

public enum DatabaseConnectionManager {
    INSTANCE;

    private String connectionString;

    DatabaseConnectionManager() {
        connectionString = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Singleton initialized");
    }

    public boolean connect() {
        System.out.println("Connecting to " + connectionString);
        return false;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

}
