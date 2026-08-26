package multithreading.executorframework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMain {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<Integer> callable1 = () -> 1;
        Callable<Integer> callable2 = () -> 2;
        Callable<Integer> callable3 = () -> 3;

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);
        executorService.invokeAll(list);


    }
}
