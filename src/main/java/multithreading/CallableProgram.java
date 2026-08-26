package multithreading;


import java.util.concurrent.*;

class MyMath {
    public static int add(int a, int b) {
        return a+b;
    }
}

//class MyAddTask implements Callable<Integer> {
//    int x;
//    int y;
//    public MyAddTask(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    @Override
//    public Integer call() {
//        int result = MyMath.add(x,y);
//        return result;
//    }
//}

public class CallableProgram {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int x = 10;
        int y = 20;

        ExecutorService executor = Executors.newFixedThreadPool(1);
        // Future<Integer> future = executor.submit(new MyAddTask(x, y));

        Future<Integer> future = executor.submit(() -> MyMath.add(x, y));

//        while( !future.isDone()) {
//
//        }
        int z = future.get();
        System.out.println("Result is ::: " +z);
    }
}
