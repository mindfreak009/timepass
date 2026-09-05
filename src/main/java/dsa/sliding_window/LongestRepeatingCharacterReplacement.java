package dsa.sliding_window;

// LeetCode 424

// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
// You can perform this operation at most k times.

//Return the length of the longest substring containing the same letter you can get after performing the above operations.

// Example 1:
// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

// Example 2:
// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.

// Constraints:
// 1 <= s.length <= 10^5
// s consists of only uppercase English letters.
// 0 <= k <= s.length

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        // String s = "ABAB";
        // int k = 2;
        String s = "AABABBA";
        int k = 1;

        System.out.println("Final ans:: " +characterReplacement(s, k));
    }
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;


        for (int right = 0; right < s.length(); right++) {
            // Update the frequency of the current character
            freq[s.charAt(right) - 'A']++;
            System.out.println("freq:: " + Arrays.toString(freq));

            // Track the maximum frequency of any single character inside the current window
            // Update the maxFrequency
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) -'A']);
            System.out.println("maxFreq:: " + maxFreq);

            int windowLength = right - left + 1;
            // Current window size is (right - left + 1)
            // Number of characters to replace is: (window size - maxFreq)
            // If replacements needed exceeds k, shrink the window from the left
            if(windowLength - maxFreq > k) {
                freq[s.charAt(left) -'A']--;
                left++;
            }

            windowLength = right - left + 1;
            //Track the maximum length of a valid window
            maxWindow = Math.max(maxWindow, windowLength);
            System.out.println("maxWindow ::" + maxWindow);
        }
        return maxWindow;
    }
}
