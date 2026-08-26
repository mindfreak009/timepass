package designpatterns.behavioral.observer.example2;

// In this subject changes, the state of all its dependent object notified the changes.
// One-to-Many relation.

public class ObserverDesignMain {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();
        Subscriber subscriber = new Subscriber();
        channel.subscribe(subscriber);
        channel.notifyChanges();
    }
}
