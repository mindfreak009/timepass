package dsa.queue;

public class ImplementCircularQueueUsingArray {
    static class MyQueue{
        static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1;

        MyQueue(int n) {
            arr = new int[n];
            size = n;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear+1) % size == front;
        }

        // enqueue - O(1)
        public static void add(int data) {
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            // 1st element add
            if(front == -1) {
                front = 0;
            }
            rear = (rear+1) % size;
            arr[rear] = data;
        }

        // dequeue - O(1)
        public static int remove() {
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[front];

            // single element condition
            if(rear == front) {
                rear = front = -1;
            } else {
                front = (front+1) % size;
            }
            return result;
        }

        // peek - O(N)
        public static int peek() {
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }

//        public static void printQueue() {
//            for (int i = 0; i<=rear ; i++) {
//                //System.out.println(queue[i]);
//                if(i != rear) {
//                    System.out.println(", ");
//                }
//            }
//            System.out.println();
//        }

    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);
      MyQueue.add(1);
      MyQueue.add(2);
      MyQueue.add(3);
      MyQueue.add(4);
      MyQueue.add(5);

       //  System.out.println(MyQueue.peek());
        while(!MyQueue.isEmpty()) {
            System.out.print(MyQueue.peek() + " ");
            MyQueue.remove();
        }


    }
}
