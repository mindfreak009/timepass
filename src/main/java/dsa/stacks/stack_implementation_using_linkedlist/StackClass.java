package dsa.stacks.stack_implementation_using_linkedlist;

public class StackClass {

    static class Node<T> {
        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
            this.next = next;
        }
    }

    static class Stack {
        public static Node head;

        public static boolean isEmpty() {
            return head == null;
        }
        public static void push(int data) {
            Node newNode = new Node(data);
            if(isEmpty()) {
                head = newNode;
                return;
            }
           // newNode.next=
        }
    }
    public  void main(String[] args) {

    }
}
