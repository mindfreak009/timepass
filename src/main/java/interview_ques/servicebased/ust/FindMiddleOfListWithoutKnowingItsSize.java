package interview_ques.servicebased.ust;

// This approach is called "Slow and Fast pointers"
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }

    public static Node findMiddleElement(Node head) {

        Node slow = head;
        Node fast = head;

        while(slow != null && fast.next != null){
            slow = slow.next;         // Moves 1 step
            fast = fast.next.next;    // Moves 2 step
        }

        return slow;
    }
}


public class FindMiddleOfListWithoutKnowingItsSize {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node middleElement = Node.findMiddleElement(head);
        System.out.println("Middle element is:: " +middleElement.data);
    }


}
