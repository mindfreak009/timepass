package dsa.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


// Time Complexity : O(k) + O(k) + O(n-k)
//                   = O(n+k)
//                   = O(n)            discarding the low value here. i.e.., (k)

// Space Complexity : O(n)

public class Reverse_K_Elements_In_Queue {
    public static void main(String[] args) {

        int[] arr = {3,10,2,12,19,6,8,10,14};

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        int k = 4;
        Queue<Integer> integers = reverseKElementsInQueue(queue, k);
        System.out.println(integers);

    }

    private static Queue<Integer> reverseKElementsInQueue(Queue<Integer> queue, int k) {

        Stack<Integer> stack = new Stack<>();
        int n = queue.size();

        for (int i = 0; i < k ; i++) {
            int temp = queue.remove();
            stack.push(temp);
        }

        for (int i = 1; i <=k; i++) {
            int temp = stack.pop();
            queue.add(temp);
        }

        for (int i = 0; i < n-k ; i++) {
            int temp = queue.remove();
            queue.add(temp);
        }
        return queue;
    }
}
