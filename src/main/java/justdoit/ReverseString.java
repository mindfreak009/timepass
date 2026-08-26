package justdoit;

import java.util.Arrays;
import java.util.Stack;

// Output : code good write I
public class ReverseString {
    public static void main(String[] args) {
        String str = "I write good code";
        reverseStringUsingStack(str);
        reverseStringUsingTraditionalApproach(str);
    }

    private static void reverseStringUsingTraditionalApproach(String str) {
        System.out.println("\n<===== AFTER HERE =====>");
        String[] s = str.split(" ");
        for (int i = s.length-1; i >=0 ; i--) {
            System.out.print(s[i] + " ");
        }
    }

    private static void reverseStringUsingStack(String str) {

        // Split the string into words
        String[] words = str.split("\\s+");

        // Create a stack to store the words in reverse order
        Stack<String> stack = new Stack<>();
        for (String word : words) {
            stack.push(word);
        }

        // Reconstruct the string by popping words from the stack
        StringBuilder reversedStr = new StringBuilder();
        while (!stack.isEmpty()) {
            // reversedStr.append(stack.pop()).append(" ");
            System.out.print(stack.pop() + " ");
        }
    }
}
