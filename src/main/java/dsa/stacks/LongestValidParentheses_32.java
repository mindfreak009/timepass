package dsa.stacks;

// Difficulty: HARD

// Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring

// Example 1:
// Input: s = "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()".

// Example 2:
// Input: s = ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()".

// Example 3:
// Input: s = ""
// Output: 0

import java.util.Stack;

public class LongestValidParentheses_32 {
    public static void main(String[] args) {
        String str1 = "(()";      // output: 2
        String str2 = "())(())";  // output: 4
        String str3 = ")()()))()(())()()(";  // output: 10

        System.out.println(longestValidParentheses(str1));
        System.out.println(longestValidParentheses(str2));
        System.out.println(longestValidParentheses(str3));

        System.out.println("=========================================");
        System.out.println(longestValidParenthesisImproved(str1));
        System.out.println(longestValidParenthesisImproved(str2));
        System.out.println(longestValidParenthesisImproved(str3));
    }

    public static int longestValidParenthesisImproved(String str) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        stack.push(-1);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                stack.push(i);  // inserting index, instead of value
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                   stack.push(i);  // simply insert the index, if the stack is empty
                }
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    // Time Complexity: O(N)
    public static int longestValidParentheses(String str) {
        int left = 0;
        int right= 0;
        int max = 0;

        // Traversing from left to right
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                left++;
            } else if(ch == ')') {
                right++;
            }

            if(left == right) {
                max = Math.max(max, left*2);
            } else if(right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;
        // Traversing from right to left
        for(int i=str.length()-1; i>=0; i--) {
            char ch = str.charAt(i);
            if(ch == '(') {
                left++;
            } else if(ch == ')') {
                right++;
            }

            if(left == right) {
                max = Math.max(max, right*2);
            } else if(left > right) {
                left = 0;
                right = 0;
            }
        }
        return max;
    }
}
