package multithreading.countdownlatch;

import java.util.concurrent.*;

public class CountDownLatchExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int numberOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        // creating an object of CountDownLatch
        CountDownLatch latch = new CountDownLatch(numberOfServices);
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));

// The main task (thread)  waits for four threads
        latch.await();

//        Future<String> future1 = executorService.submit(new DependentService());
//        Future<String> future2 = executorService.submit(new DependentService());
//        Future<String> future3 = executorService.submit(new DependentService());
//        Future<String> future4 = executorService.submit(new DependentService());

//        future1.get();
//        future2.get();
//        future3.get();
//        future4.get();

        System.out.println("All dependent services finished. Starting main service");
        System.out.println("Main");
        executorService.shutdown();
    }
}

class DependentService implements Callable<String> {

    private final CountDownLatch countDownLatch;

    public DependentService(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " service started ");
            Thread.sleep(2000);
        } finally {
            countDownLatch.countDown();
        }

        return "ok";
    }
}
