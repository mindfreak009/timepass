package functional;

class ThreadDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside upper method");
    }
}

public class RunnableLambdaExample {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new ThreadDemo());
        thread1.start();

        Thread thread = new Thread(() -> System.out.println("Inside run method"));
        thread.start();
    }
}
