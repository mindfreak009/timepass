package multithreading.reentrantlock.example3;

public class Main {
    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(50);
            }
        };

        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");

        thread1.start();
        thread2.start();

    }
}
