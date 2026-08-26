package multithreading.even_and_odd_printer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

public class EvenAndOddPrinterByCompletableFuture {

    static Semaphore odd = new Semaphore(1);
    static Semaphore even = new Semaphore(0);

    public static void main(String[] args) {
        CompletableFuture<Void> oddTask = CompletableFuture.runAsync(() -> {
            for (int i = 1; i <=10; i+=2) {
                try {
                    odd.acquire();
                    System.out.println("Odd: " +i);
                    even.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        CompletableFuture<Void> evenTask = CompletableFuture.runAsync(() -> {
            for (int i = 2; i <=10; i+=2) {
                try {
                    even.acquire();
                    System.out.println("Even: " +i);
                    odd.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        CompletableFuture.allOf(oddTask, evenTask).join();
    }
}
