package multithreading.even_and_odd_printer;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenAndOddPrinter {

    private static Object object = new Object();

    private static IntPredicate evenCondition = e-> e%2 == 0;
    private static IntPredicate oddCondition = e-> e%2 != 0;

    public static void printResults(IntPredicate condition) {
        IntStream.rangeClosed(1, 10)
                .filter(condition)
                .forEach(EvenAndOddPrinter::execute);
    }

    public static void execute(int i){
        synchronized (object) {
            try {
                System.out.println("Thread name :" + Thread.currentThread().getName()+ " : " +i);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                // throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> EvenAndOddPrinter.printResults(oddCondition));
        CompletableFuture.runAsync(() -> EvenAndOddPrinter.printResults(evenCondition));
        Thread.sleep(1000);
    }


}
