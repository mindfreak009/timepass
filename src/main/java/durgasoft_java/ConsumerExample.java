package durgasoft_java;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<Integer> squareNum = i -> System.out.println("Taking an input and performing square :: " + i*i);
        squareNum.accept(5);

        Consumer<Integer> doubleNum = i -> System.out.println("Taking an input and performing addition :: " + (i+i));
        doubleNum.accept(4);

        squareNum.andThen(doubleNum).accept(10);

    }
}
