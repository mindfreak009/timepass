package interviewtime;

import java.util.LinkedList;
import java.util.Queue;

public class Interview12 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        for (int i = queue.size()-1; i >=0; i--) {
            System.out.print(queue.poll() + " ");
        }
    }
}
