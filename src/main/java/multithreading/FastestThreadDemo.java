package multithreading;

public class FastestThreadDemo {

    public static void main(String[] args) {
        // Create and start threads
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new WorkerThread("Thread " + (i + 1));
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class WorkerThread extends Thread {
        public WorkerThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            // Perform the task here
            for (int i = 0; i < 1000000; i++) {
                Math.sin(i);
            }
            long duration = System.currentTimeMillis() - startTime;
            System.out.println(getName() + " completed in " + duration + " ms");
        }
    }
}

