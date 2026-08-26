package dsa.stacks;

import java.util.Collections;
import java.util.Stack;

// Time complexity : O(n logn)
// Space complexity : O(N)
public class Anagram {
    public static void main(String[] args) {
        String str1 = "listen    " ;
        String str2 = "silent  " ;

        System.out.println(str1.trim().length());
        System.out.println(str2.trim().length());

        boolean result = checkAnagram(str1, str2);
        if(result)
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        else
            System.out.println(str1 + " and " + str2 + " are NOT anagrams.");

    }

    private static boolean checkAnagram(String str1, String str2) {
        str1 = str1.trim();
        str2 = str2.trim();

        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to character arrays
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // Sort character arrays using stack
        Stack<Character> stack1 = sortCharArray(charArray1);
        Stack<Character> stack2 = sortCharArray(charArray2);

        return stack1.equals(stack2);
    }

    private static Stack<Character> sortCharArray(char[] charArray) {
        Stack<Character> stack = new Stack<>();
        // Push characters onto stack
        for (char c : charArray) {
            stack.push(c);
        }
        // Sort stack
        Collections.sort(stack);
        return stack;
    }
}
