package multithreading.even_and_odd_printer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

// We want to execute in 2 different threads, if we don't do it then CompletableFuture would execute it in
// Fork join pool. Hence we need to declare ExecutorService and define 2 threads.
public class EvenAndOddPrinterByExecutorService  {

    public static void main(String[] args) {

        // Declaring two threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.rangeClosed(1, 10)
                .forEach(num -> {
                    CompletableFuture<Integer> oddCompletableFuture = CompletableFuture.completedFuture(num)
                            .thenApplyAsync(x -> {
                                if(x % 2 != 0) {
                                    System.out.println("Thread name :" + Thread.currentThread().getName()+ " : " +x);
                                }
                                return num;
                            }, executorService);
                    oddCompletableFuture.join();

                    CompletableFuture<Integer> evenCompletableFuture = CompletableFuture.completedFuture(num)
                            .thenApplyAsync(x -> {
                                if(x % 2 == 0) {
                                    System.out.println("Thread name :" + Thread.currentThread().getName()+ " : " +x);
                                }
                                return num;
                            }, executorService);
                    evenCompletableFuture.join();
                });
        executorService.shutdown();
    }
}
