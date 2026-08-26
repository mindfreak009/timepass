package interviewtime;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Sorting of Linked List : A B C D E
// Output:  E D C B A
public class Interview11 {
    public static void main(String[] args) {
        List<Character> list = new LinkedList<>(Arrays.asList('A', 'B', 'C', 'D', 'E'));
        reverseLinkedList(list);
    }

    private static void reverseLinkedList(List<Character> list) {
        for (int i = list.size()-1; i >= 0 ; i--) {
            System.out.print(list.get(i) + " ");
        }

    }
}
