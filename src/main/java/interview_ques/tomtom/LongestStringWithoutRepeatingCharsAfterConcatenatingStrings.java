package interview_ques.tomtom;


// Topics: Dynamic Programming, Arrays

// Concatenation is an operation that joins strings.
// For e.g., the concatenation of strings "smart" and "phone" is "smartphone".
// Concatenation can be expanded to more than 2 strings; for e.g.., concatenating "co", "dil", and "ity" results in "codility".

// Given a array A consisting of strings, your function should calculate the length of the longest string S such that"
   // S is a concatenation of some of the strings from A
   // every letter in S is different.


// Example 1:
// String str= {"co", "dil", "ity"};       // Output: 5
// The resulting string could be: ["codil", "dilco", "coity" or "ityco"];

// Example 2:
// String str= {"abc", "yyy", "def", "csv"};     // Output: 6
// The resulting string could be: ["abcdef", "defabc", "defcsv", "csvdef"];

// Example 3:
// String str= {"potato", "kayak", "banana", "racecar"};   // Output: 0
// It is impossible to choose any of these strings as each of them contains repeating letters.

// Example 4:
// String str= {"eva", "jqw", "tyn", "jan"};    // Output: 9
// One of the possible strings of this length is "evajqwtyn";

import java.util.HashSet;

public class LongestStringWithoutRepeatingCharsAfterConcatenatingStrings {
    public static void main(String[] args) {
        String[] str1 = {"potato", "kayak", "banana", "racecar"}; // Output: 0
        System.out.println(longestString(str1));

        String[] str2 = {"co", "dil", "ity"};   // Output: 5
        System.out.println(longestString(str2));

        String[] str3 = {"abc", "yyy", "def", "csv"}; // Output: 6
        System.out.println(longestString(str3));

        String[] str4 = {"eva", "jqw", "tyn", "jan"}; // Output: 9
        System.out.println(longestString(str4));

    }

    // Function to find the length of the longest string without repeating characters
    public static int longestString(String[] str) {
        return helper(str, "", 0);
    }

    // Helper function that performs the combination of strings and checks for uniqueness of characters
    public static int helper(String[] str, String current, int index) {
        // If we've processed all strings, return the length of the current valid string
        if (index == str.length) {
            return current.length();
        }

        // Option 1: Skip the current string
        int maxLen = helper(str, current, index + 1);

        // Option 2: Include the current string, but first check if it contains unique characters when appended
        String nextString = str[index];
        if (isUnique(current + nextString)) {
            maxLen = Math.max(maxLen, helper(str, current + nextString, index + 1));
        }

        return maxLen;
    }

    // Function to check if a string has unique characters
    public static boolean isUnique(String str) {
        HashSet<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return false; // Duplicate character found
            }
            set.add(c);
        }
        return true; // All characters are unique
    }
}
