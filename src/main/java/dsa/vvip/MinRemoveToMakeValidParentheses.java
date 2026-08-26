package dsa.vvip;

// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
// so that the resulting parentheses string is valid and return any valid string.

// Example 1:
// Input: s = "lee(t(c)o)de)"
// Output: "lee(t(c)o)de"
// Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

// Example 2:
// Input: s = "a)b(c)d"
// Output: "ab(c)d"

// Example 3:
// Input: s = "))(("
// Output: ""
// Explanation: An empty string is also valid.

import java.util.Stack;

public class MinRemoveToMakeValidParentheses {
    public static void main(String[] args) {
       String s = "lee(t(c)o)de)";
      //  String s = "a)b(c)d";
        String finalResult = minRemoveToMakeValid(s);
        System.out.println("finalResult :: " +finalResult);
    }

    private static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            char c = sb.charAt(i);
            if(c == '('){
                stack.push(i);
            } else if (c == ')') {
                if(!stack.isEmpty() && sb.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }

        System.out.println("stack :: " +stack);

        while(!stack.isEmpty()){
           int removeIndex =  stack.pop();
           sb.deleteCharAt(removeIndex);
        }
        return sb.toString();
    }
}
