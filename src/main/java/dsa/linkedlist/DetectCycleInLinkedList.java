package dsa.linkedlist;

public class DetectCycleInLinkedList {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        DetectCycleInLinkedList d = new DetectCycleInLinkedList();
    }
}

// Solution using: Floyd's Cycle Detection Algorithm
// Time Complexity : O(N)
// Space Complexity: O(1)

//public boolean hasCycle(ListNode head) {
//    ListNode slow = head;
//    ListNode fast = head;
//
//    while(fast !=null && fast.next !=null) {
//        slow = slow.next;
//        fast = fast.next.next;
//
//        if(slow == fast) {
//            return true;
//        }
//    }
//    return true;
//}