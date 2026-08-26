package random_coding;

public class PrintNumbersSequentiallyUsingMultipleThreads {
    public static void main(String[] args) {
        PrintNumbersSequentiallyUsingMultipleThreads mt = new PrintNumbersSequentiallyUsingMultipleThreads();

        MyRunnable r = new MyRunnable();
         Thread t = new Thread(r);

        t.start();
//        t.start();

    }
}

class MyRunnable implements Runnable {

    private static final int LIMIT = 20;
    private static volatile int counter = 0;
    private int id;

    public MyRunnable() {
        //this.id = id;
    }
//    public MyRunnable(int id) {
//        this.id = id;
//    }

    @Override
    public void run() {
        outer:
        while(counter < LIMIT) {
            while (counter % 10 != id) {
                if(counter == LIMIT) break outer;
            }
            System.out.println("Thread "+Thread.currentThread().getName()+ " printed " + counter);
            counter += 1;
        }
    }
}