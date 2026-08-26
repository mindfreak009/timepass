package dsa.stacks;

// Time Complexity : O(N)
// Space Complexity : O(N) ... because extra space of Stack<Character> is used

import java.util.Stack;

public class ValidParenthesesInString {
    public static void main(String[] args) {
       // char[] ch = { '(', ')', '{', '}', '[', ']', '+' } ;
        char[] ch = { '(', ')', '{', '}', '[', ']' } ;
        String str = new String(ch);
        System.out.println(isValid(str));
    }

    public static boolean isValid(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if(!st.isEmpty()) {
                    char top = st.peek();
                    if ((ch == ')'  && top == '(')
                             || (ch == '}'  && top == '{')
                                || (ch == ']'  && top == '[')) {
                        st.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if(st.isEmpty()) return true;

        return false;
    }
}
