package multithreading.virtualthreads;

public class VirtualThread1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " START ");
        System.out.println("Working on some tasks");

        // going to start virtual thread
        Thread.startVirtualThread(() -> {
            System.out.println("This is a virtual thread::");
            for (int i = 0; i < 10; i++) {
                System.out.println("Virtual Thread" + i + "");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + " END ");
    }
}
