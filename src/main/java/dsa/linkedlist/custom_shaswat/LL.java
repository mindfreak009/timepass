package dsa.linkedlist.custom_shaswat;

public class LL {

    public static void main(String[] args) {
        LL linkedList = new LL();
//        linkedList.insertTail(10);
//        linkedList.insertTail(20);
//
//        linkedList.insertHead(5);
//        linkedList.printList();
//        linkedList.insertNode(40, 5);
//        linkedList.insertNode(40, 4);
//        linkedList.insertNode(35, 4);
//        linkedList.insertNode(68, 5);
//        linkedList.insertNode(78, 6);
//        linkedList.printList();

//        System.out.println(linkedList.getSize());
//        linkedList.deleteTail();
//        linkedList.printList(); BHJ67Y8
//        linkedList.deleteHead();
//        linkedList.printList();
//        linkedList.deleteNode(3);
//        linkedList.printList();

        linkedList.insertNode(10,1);
        linkedList.insertNode(20, 2);
        linkedList.insertNode(30, 3);
        linkedList.insertNode(40, 4);
        linkedList.printList();
        linkedList.updateNode(3,  50);
        linkedList.printList();
        linkedList.searchNode(40);



    }
    Node<Integer> head;
    int size;
    LL() {
        this.head = null;
        this.size = 0;
    }

    // add at any position
    public void insertNode(int data, int position) {
        if(position>size+1 || position <= 0) {
            System.out.println("Wrong input");
            return;
        }
        if(position == 1) {
            insertHead(data);
        } else if (position == size+1) {
            insertTail(data);
        } else {
           int counter =1 ;
           Node<Integer> newNode = new Node<>(data);
           Node<Integer> temp = head;
           while(counter < position-1 && temp != null) {
               counter++;
               temp = temp.next;
           }
           newNode.next = temp.next;
           temp.next = newNode;
           size++;
        }
        System.out.println("Insertion successful at position " +position);
    }

    public void printList() {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.println("Data is :: " + temp.data);
            temp = temp.next;
        }
        System.out.println(" ");
    }
    public void insertHead(int data) {
        Node<Integer> newNode = new Node<>(data);
        if(head == null) {
            head = newNode;
            System.out.println("<=== Insertion at head is successful ==> ");
            size++;
            return;
        }
        // otherwise, if head is already having value
        newNode.next = head;
        head = newNode;
        System.out.println("<=== Insertion at head is successful ==> ");
        size++;
    }

    public void insertTail(int data) {
        Node<Integer> newNode = new Node<>(data);
        if(head == null) {
            head = newNode;
            System.out.println("Insertion at tail is successful");
            size++;
            return;
        }
        // otherwise, if tail is already having value
        // create a new node and point it to head and start the iteration
        Node<Integer> temp = head;
        while(temp.next !=null) {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Insertion at tail is successful");
        size++;
    }

    public void deleteHead() {
        if(head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        // otherwise, if head is having some value
        Node<Integer> temp = head;
        head = head.next;
        temp.next = null;
        System.out.println("Deletion at head is successful");
        size--;
    }

    public void deleteTail() {
        if(head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        if(head.next == null) {
            head = null;
            size--;
            System.out.println("Deletion of tail is successful");
            return;
        }
        // otherwise, if tail is already having value
        // create a new node and point it to head and start the iteration
        Node<Integer> temp = head;
        Node<Integer> prev = null;
        while(temp.next !=null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        System.out.println("Deletion at tail is successful");
        size++;
    }

    public void deleteNode(int position) {
        if(position >= size+1 || position <= 0) {
            System.out.println("Wrong input");
            return;
        }
        // head
        if(position == 1) {
            deleteHead();
        } else if (position == size) {
            deleteTail();
        } else {
            int counter =1 ;
            Node<Integer> prev = null;
            Node<Integer> temp = head;
            while(counter < position && temp != null) {
                counter++;
                prev = temp;   // this was the condtion that was failing
                temp = temp.next;
            }
            prev.next = temp.next;
            temp.next = null;
            size--;
            System.out.println("Deletion successful at position " +position);
        }
    }

    public void updateNode(int position, int updatedValue) {
        if(head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        int counter = 1;
        Node<Integer> temp = head;
        while(counter < position && temp != null) {
            counter++;
            temp = temp.next;
        }
        if(temp != null && counter == position) {
            temp.data = updatedValue;
        } else {
            System.out.println("Size of Linked List is smaller than position" + position);
        }
        System.out.println("Updated at position " + position + " was successful");
    }

    public boolean searchNode(int searchedValue) {
        if(head == null) {
            System.out.println("Linked List is empty");
            return false;
        }

        int counter = 1;
        Node<Integer> temp = head;
        while(temp != null) {
            if(temp.data == searchedValue) {
                System.out.println(searchedValue + " was successfully found at position : " + counter);
                return true;
            }
            counter++;
            temp = temp.next;
        }

        System.out.println("Searched value NOT found");
        return false;
    }


    public String getSize() {
        return "Linked List size is ::: " + size;
    }

}


class Node<T> {
    T data;
    Node next;

    Node() {
        this.next = null;
    }
    Node(T data) {
        this.data = data;
        this.next = null;
    }

}