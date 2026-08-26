package multithreading.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(9);
        for (int i = 1; i < 10; i++) {

            int finalI = i;
            executor.submit( () -> {
                long result = factorial(finalI);
                System.out.println(result);

            });
            executor.shutdown();
        }
    }

    public static long factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result*i;
        }
        return result;
    }
}
