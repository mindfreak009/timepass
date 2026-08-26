package dsa.queue.circularqueue;

public class CircularQueueMain {
    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue();
        queue.insert(3);
        queue.insert(6);
        queue.insert(5);
        queue.insert(19);
        queue.insert(1);
        queue.insert(73);

        queue.display();

        System.out.println(queue.remove());
    }
}
