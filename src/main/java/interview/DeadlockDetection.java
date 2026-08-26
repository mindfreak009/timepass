package interview;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadlockDetection {

    // Resource 1
    private static final Object resource1 = new Object();

    // Resource 2
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        // Start the two processes in separate threads
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process2();
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Check for deadlock during execution
        try {
            // Check for deadlock periodically
            while (true) {
                Thread.sleep(50); // Wait for some time before checking
                if (checkForDeadlock()) {
                    System.out.println("Deadlock detected between Process 1 and Process 2!");
                    break;
                }
            }

            // Wait for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Process 1: Tries to lock resource1 first and then resource2
    public static void process1() {
        synchronized (resource1) {
            System.out.println("Process 1: Holding resource 1...");

            // Simulate some work
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Process 1: Waiting for resource 2...");

            // Now try to acquire resource2, potentially causing deadlock if Process 2 holds resource2
            synchronized (resource2) {
                System.out.println("Process 1: Acquired resource 2!");
            }
        }
    }

    // Process 2: Tries to lock resource2 first and then resource1
    public static void process2() {
        synchronized (resource2) {
            System.out.println("Process 2: Holding resource 2...");

            // Simulate some work
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Process 2: Waiting for resource 1...");

            // Now try to acquire resource1, potentially causing deadlock if Process 1 holds resource1
            synchronized (resource1) {
                System.out.println("Process 2: Acquired resource 1!");
            }
        }
    }

    // Method to check if a deadlock exists using ThreadMXBean
    public static boolean checkForDeadlock() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // Get the IDs of any deadlocked threads
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();

        // If deadlocked threads are found, a deadlock is detected
        return deadlockedThreads != null && deadlockedThreads.length > 0;
    }
}
