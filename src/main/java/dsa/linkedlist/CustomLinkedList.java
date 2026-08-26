package dsa.linkedlist;

// LinkedList is also a linear data structure.
// Custom LinkedList implementation
// Shraddha Khapra - Apna College
public class CustomLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CustomLinkedList() {
    }

    public CustomLinkedList(int size) {
        this.size = 0;
    }

    public  void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null) {
            tail = head;
        }
        size += 1;
    }

    private void insertLast(int val) {
        if (tail == head) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index) {
        if(index == 0) {
            insertFirst(val);
            return;
        }
        if(index == size) {
            insertLast(val);
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public int deleteFirst() {
        int val = head.data;
        head = head.next;

        if(head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast() {
       if(size <=1) {
            return deleteFirst();
       }

        Node secondLast = get(size - 2);
        int val = tail.data;
        tail = secondLast;
        tail.next = null;
       return val;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if(index == size-1) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.data;

        prev.next = prev.next.next;
        return  val;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index ; i++) {
            node = node.next;
        }
        return node;
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insertFirst(3);
        list.insertFirst(7);
        list.insertFirst(2);
        list.insertFirst(10);
        list.insertLast(66);
        list.insert(100, 3);

        list.display();
        System.out.println(list.deleteFirst());
        list.display();
    }


}
