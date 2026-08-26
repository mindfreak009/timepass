package multithreading.threading;

import static multithreading.WhyNotFuture.delay;

public class HelloWorldThreadExample {
    private static String result = "";

    private static void hello() {
        delay(500);
        result = result.concat("Hello");
    }

    private static void world() {
        delay(500);
        result = result.concat("World");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread helloThread = new Thread(() -> hello());
        Thread worldThread = new Thread(() -> world());

        // Starting the thread
        helloThread.start();
        worldThread.start();

        // Joining the thread (Waiting for threads to finish)
        helloThread.join();
        worldThread.join();

        System.out.println("Result is :: " +result);
    }
}
