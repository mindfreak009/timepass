package dsa.queue;


import java.util.Arrays;

public class MyQueue {

    int rear;
    int front;
    int capacity;
    int size;
    int[] queue;

    public MyQueue(int capacity) {
        queue = new int[capacity];
        this.capacity = capacity;
        size = 0;
        rear = front = -1;
    }


    public boolean isEmpty() {
        if(front == -1 || rear == -1) {
            return  true;
        }
        return false;
    }

    // check if Queue is full
    public boolean isFull() {
        if(rear == capacity-1) {
            return true;
        }
        return false;
    }

    // check if Queue is full
    public int peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            throw new IllegalArgumentException("Queue is empty");
        }
        return queue[front];
    }

    // check if elements can be added in Queue
    public void enqueue(int val) {
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }

        if(isEmpty()) {
            front = 0;
            rear = 0;
          //  queue[0] = val;
        } else {
            rear++;
          //  queue[rear] = val;
        }
        size++;
        queue[rear] = val;
    }

    //  logic to delete elements in Queue
    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int val = queue[front];
        if(front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        size--;
        return val;
    }

    public void printQueue() {
        for (int i = front; i<=rear ; i++) {
            //System.out.println(queue[i]);
            if(i != rear) {
                System.out.println(", ");
            }
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "rear=" + rear +
                ", front=" + front +
                ", capacity=" + capacity +
                ", size=" + size +
                ", queue=" + Arrays.toString(queue) +
                '}';
    }

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue(5);
        System.out.println("Capacity is :" +5);
        myQueue.printQueue();
        System.out.println("Insert element :: "+7);
        myQueue.enqueue(7);
        System.out.println("Peek element :: " +myQueue.peek());
        System.out.println("Insert element :: "+8);
        myQueue.enqueue(8);
        System.out.println("Peak element :: " +myQueue.peek());
        System.out.println("=======================================");
        System.out.println(myQueue);


    }
}
