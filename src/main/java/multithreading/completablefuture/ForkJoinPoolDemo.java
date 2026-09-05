package multithreading.completablefuture;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolDemo {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        ForkJoinPool pool = new ForkJoinPool();
        SumTask sumTask = new SumTask(arr, 0, arr.length-1);
        Integer result = pool.invoke(sumTask);

        System.out.println(result);
        //findSum(arr);
        pool.shutdown();
    }

//    public static void findSum(int[] arr) {
//        Arrays.stream(arr)
//                .map(i -> i)
//                .
//    }
}

class SumTask extends RecursiveTask<Integer> {

    private int[] arr;
    private int start;
    private int end;

    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        // Base condition
        if(end - start <= 2) {
            int sum = 0;
            for (int i = start; i <=end ; i++) {
                sum+= arr[i];
            }
            return sum;
        }
        // main logic -> fork
        int mid = start + (end-start)/2;
        SumTask leftTask = new SumTask(arr, start, mid);
        SumTask rightTask = new SumTask(arr, mid+1, end);

        leftTask.fork();
        int sum2 = rightTask.compute();
        int sum1 = leftTask.join();


        // join
        return sum1 + sum2;
    }
}
