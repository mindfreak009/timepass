package multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class WhyNotFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        Future<List<Integer>> future = executorService.submit(() -> {
//            System.out.println("Thread :: " +Thread.currentThread().getName());
//            delay(1);
//            return Arrays.asList(1, 2, 3, 4, 5);
//        });
//
//        List<Integer> integerList = future.get();
//        System.out.println(integerList);
//        System.out.println("future isdone()" +future.isDone());

        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        delay(1);
        completableFuture.get();
        completableFuture.complete("return some value");
    }

    public static void delay(int min) {
        try {
            TimeUnit.MINUTES.sleep(min);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
