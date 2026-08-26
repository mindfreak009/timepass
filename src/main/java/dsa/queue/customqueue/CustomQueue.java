package dsa.queue.customqueue;

public class CustomQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE=10;

    int end = 0;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public static void main(String[] args) {

    }

}
