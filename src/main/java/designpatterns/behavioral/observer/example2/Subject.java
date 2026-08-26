package designpatterns.behavioral.observer.example2;

interface Subject {
    void subscribe(Observer ob);
    void unsubscribe(Observer ob);
    void notifyChanges();


}
