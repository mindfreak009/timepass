package dsa.queue;

public class ImplementQueueUsingArray {
    static class MyQueue{
        static int arr[];
        static int size;
        static int rear = -1;

        MyQueue(int n) {
            arr = new int[n];
            size = n;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        // enqueue
        public static void add(int data) {
            if(rear == size-1){
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        // dequeue - O(N)
        public static int remove() {
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i <rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
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
