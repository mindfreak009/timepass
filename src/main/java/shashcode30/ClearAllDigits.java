package shashcode30;
// Difficulty: Easy

// You are given a string s.
// Your task is to remove all digits by doing this operation repeatedly:

// Delete the first digit and the closest non-digit character to its left.
// Return the resulting string after removing all digits.

// Example 1:
// Input: s = "abc"
// Output: "abc"
// Explanation: There is no digit in the string.

// Example 2:
// Input: s = "cb34"
// Output: ""
// Explanation:
// First, we apply the operation on s[2], and s becomes "c4".
// Then we apply the operation on s[1], and s becomes "".

// Constraints:
//      1 <= s.length <= 100
//      s consists only of lowercase English letters and digits.
//      The input is generated such that it is possible to delete all digits.

import java.util.Stack;

public class ClearAllDigits {
    public static void main(String[] args) {
        // String str = "cb34";
        String str = "abc";
        System.out.println(clearDigits(str));
    }

    public static String clearDigits(String str) {

        // Stack for storing the
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            // 1. adding only characters in the stack.
            if(!Character.isDigit(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else {
                // 2. when numbers are encountered, simply remove from the stack.
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }

        System.out.println(stack);
       StringBuilder sb = new StringBuilder();
        // Since Stack stores objects in LIFO order, we are store objects in  Stringbuilder by continuously popping it from Stack.
        // This way, we would get objects in correct order.
       while (!stack.isEmpty()) {
           System.out.println(stack.pop());
           // sb.insert(0, stack.pop());
       }

       return sb.toString();
    }
}
