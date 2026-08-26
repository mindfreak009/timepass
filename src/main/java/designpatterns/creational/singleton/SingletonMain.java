package designpatterns.creational.singleton;

public class SingletonMain {
    public static void main(String[] args) {
        SingletonClass clazz = SingletonClass.getSingleton();
        System.out.println(clazz.hashCode());

        System.out.println("=================================");
        SingletonClass clazz1 = SingletonClass.getSingleton();
        System.out.println(clazz1.hashCode());

        System.out.println("=================================");
        SingletonClass clazz2 = SingletonClass.getSingleton();
        System.out.println(clazz2.hashCode());

        System.out.println("=================================");
        SingletonClass singleton = SingletonClass.getSingleton();
        System.out.println(singleton.hashCode());


    }
}
