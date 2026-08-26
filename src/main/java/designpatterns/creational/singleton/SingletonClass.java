package designpatterns.creational.singleton;

public class SingletonClass {

    private static SingletonClass clazz;
    private SingletonClass() {}

    // To handle multithreaded environment, we can do 2 things:
    // 1. Either make the whole method synchronized
    //      for e.g..,   public static synchronized SingletonClass getSingleton(){
    // 2. Make use of static block and only make that particular block synchronized.
    //      for e.g...,   static(SingletonClass.class) { ... write your object creation code here...}

    // the 2nd approach is very efficient.

    public static SingletonClass getSingleton(){
        synchronized (SingletonClass.class) {
            if (clazz == null) {
                clazz = new SingletonClass();
            }
            return clazz;
        }
    }

}
