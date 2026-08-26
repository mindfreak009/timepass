package interview_ques;

// Input : I Am Not String
// output : g ni rtS toNmAI

import java.util.Arrays;

public class ReverseAStringPreservingSpacePosition {
    public static void main(String[] args) {
        String str = "I Am Not String";
        System.out.println(reverseStringPreservingSpaces(str));
    }


    public static String reverseStringPreservingSpaces(String input) {
        // Convert the input string to a char array to manipulate characters
        char[] arr = input.toCharArray();

        System.out.println("char array :: " + Arrays.toString(arr));

        // Create a list to hold non-space characters
        StringBuilder nonSpaceChars = new StringBuilder();

        // First pass: collect all non-space characters
        for (char c : arr) {
            if (c != ' ') {
                nonSpaceChars.append(c);
            }
        }

        System.out.println("nonSpaceChars : " + nonSpaceChars);
        // Reverse the collected characters
        nonSpaceChars.reverse();

        System.out.println("nonSpaceChars : " + nonSpaceChars);

        // output : g ni rtS toNmAI

        // Second pass: reconstruct the string, replacing non-space characters with reversed ones
        int index = 0; // Index for the reversed non-space characters
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                arr[i] = nonSpaceChars.charAt(index++);
            }
        }

        // Return the new string after modification
        return new String(arr);
    }
}
