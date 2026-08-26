package designpatterns.behavioral.observer.example2;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject{
    List<Observer> subscribers = new ArrayList<>();
    private String title;

    @Override
    public void subscribe(Observer ob) {
        this.subscribers.add(ob);
    }

    @Override
    public void unsubscribe(Observer ob) {
        this.subscribers.remove(ob);    
    }

    @Override
    public void notifyChanges() {
        for (Observer ob : this.subscribers) {
            ob.notified();
        }
    }
}
