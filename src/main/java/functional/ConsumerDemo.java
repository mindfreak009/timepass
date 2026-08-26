package functional;

import java.util.function.Consumer;

class ConsumerImpl implements Consumer<String> {
    @Override
    public void accept(String input) {
        System.out.println(input);
    }
}

public class ConsumerDemo {
    public static void main(String[] args) {
//        Consumer<String> consumer = new ConsumerImpl();
//        consumer.accept("Welcome to Java !!");

        Consumer<String> consumer2 = (s) -> System.out.println(s);
        consumer2.accept("Hello World");


    }
}
