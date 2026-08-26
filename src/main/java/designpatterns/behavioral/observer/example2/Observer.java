package designpatterns.behavioral.observer.example2;

// Observer pattern is a design pattern in which an object maintains a list of
// its dependents and notifies them automatically of any state changes.
// Also known as publish-subscribe pattern
// Used in event-driven systems
// Allows loose coupling between objects

// Example: A weather station broadcasts weather updates to multiple displays
// Example: A stock market ticker notifies multiple investors of stock price changes

public interface Observer {
    void notified();
}
