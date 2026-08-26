package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMultithreading {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            Runnable task = new MyRunnable(); // Assuming MyRunnable is a Runnable implementation
            executor.execute(task);
        }
        // Shut down the thread pool
        executor.shutdown();
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("This is a thread created by implementing the Runnable interface.");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start(); // Starts the execution of the thread
    }
}