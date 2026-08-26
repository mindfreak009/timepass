package multithreading.virtualthreads;

public class Program1 {
    public static void main(String[] args) {
        System.out.println("Work start!");
        // one thread
        System.out.println("Thread type: " + Thread.currentThread().getName());

        // var run1 = new Runnable(){

//            @Override
//            public void run() {
//                System.out.println("This is my thread");
//                System.out.println("Thread type: " + Thread.currentThread().getName());
//            }
//    };
        Runnable run1 = () -> {
            System.out.println("This is my thread");
            System.out.println("Thread type: " + Thread.currentThread().getName());

        };

        var thread1 = new Thread(run1);
        thread1.start();

    }
}
