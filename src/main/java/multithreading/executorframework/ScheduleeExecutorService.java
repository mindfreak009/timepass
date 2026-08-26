package multithreading.executorframework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleeExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(
                () -> System.out.println("Task executed at 5 sec delay"),
                    5,
                     5,
                        TimeUnit.SECONDS);

        scheduler.schedule(() -> {
                    System.out.println("Initiating shutdown !! ");
                    scheduler.shutdown();
                }, 20, TimeUnit.SECONDS);
    }
}
