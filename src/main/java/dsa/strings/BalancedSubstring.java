package dsa.strings;

import java.util.*;

public class BalancedSubstring {


        // Function to find the mutual characters in lowercase and uppercase
        public static Set<Character> findMutual(String s) {
            Set<Character> lowerSet = new HashSet<>();
            Set<Character> upperSet = new HashSet<>();

            // Iterate through string and categorize characters into lowercase and uppercase sets
            for (char c : s.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    lowerSet.add(c);
                } else if (Character.isUpperCase(c)) {
                    upperSet.add(Character.toLowerCase(c));  // Convert uppercase to lowercase
                }
            }

            // Intersect both sets to get mutual characters that appear in both cases
            lowerSet.retainAll(upperSet);
            System.out.println("lowerset :" +lowerSet);
            return lowerSet;
        }

        // Function to find the smallest balanced substring
        public static int smallestSubstring(String s) {
            Set<Character> mutualChars = findMutual(s);

            // If there are no mutual characters, return -1
            if (mutualChars.isEmpty()) {
                return -1;
            }

            int minLength = Integer.MAX_VALUE;
            int left = 0;

            // Use sliding window to find the smallest balanced substring
            for (int right = 0; right < s.length(); right++) {
                char rightChar = s.charAt(right);

                // If the character is not mutual, continue
                if (!mutualChars.contains(Character.toLowerCase(rightChar))) {
                    continue;
                }

                // If we encounter a character that is mutual, move the left pointer to find the minimum window
                while (isBalanced(s, left, right, mutualChars)) {
                    minLength = Math.min(minLength, right - left + 1);
                    left++;
                }
            }

            return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
        }

        // Helper function to check if the substring from left to right is balanced
        private static boolean isBalanced(String s, int left, int right, Set<Character> mutualChars) {
            Set<Character> windowChars = new HashSet<>();
            for (int i = left; i <= right; i++) {
                char c = s.charAt(i);
                if (mutualChars.contains(Character.toLowerCase(c))) {
                    windowChars.add(Character.toLowerCase(c));
                }
            }

            return windowChars.equals(mutualChars);
        }

        public static void main(String[] args) {
            System.out.println(smallestSubstring("azABaabza"));  // Output: 5
            System.out.println(smallestSubstring("dAcZCbaBz"));  // Output: 8
            System.out.println(smallestSubstring("TacoCat"));    // Output: -1
            System.out.println(smallestSubstring("Tt"));         // Output: 2
            System.out.println(smallestSubstring("T"));          // Output: -1
            System.out.println(smallestSubstring("TaCc"));       // Output: 4
        }

}

