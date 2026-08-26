package multithreading.threading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadEx {

    static AtomicInteger counter = new AtomicInteger();

    public static void handleRequest() {
        int count = counter.incrementAndGet();
        System.out.println("Starting thread :: "  +count + ": " + Thread.currentThread());
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Ending thread :: "  +count + ": "  +Thread.currentThread());
    }

    public static void main(String[] args) {
        for (int i = 1; i <=1000000 ; i++) {
            // 1. Normal way of creating thread
            //new Thread(() -> handleRequest()).start();

            // 2. Creating Virtual Threads
           Thread.startVirtualThread(() -> handleRequest());
        }
    }
}
