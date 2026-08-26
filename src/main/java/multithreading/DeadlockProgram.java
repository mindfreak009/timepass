package multithreading;

public class DeadlockProgram {
    public static void main(String[] args) {

        String lock1 = "Prakash";
        String lock2 = "Pangeni";

        Thread t1 = new Thread( () -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // Synchronized "lock2"
                synchronized (lock2) {
                    System.out.println("Lock acquired in t1");
                }
            }
        });

        Thread t2 = new Thread( () -> {
            // If we reverse the below order as lock1 and then lock2, the DEADLOCK situation would be GONE !!
            synchronized (lock2) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                // Synchronized "lock1"
                synchronized (lock1) {
                    System.out.println("Lock acquired in t2");
                }
            }
        });

        t1.start();
        t2.start();

    }
}
