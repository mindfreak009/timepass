package dsa.sliding_window;

// Difficulty: Medium

// Given a string s, find the length of the longest substring without repeating characters.

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc",  with teh length of 3.

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static void main(String[] args) {
        //String s = "abcabcbb";
        String s = "abcabfcd";
        System.out.println(lengthOflongestSubstring(s));
    }

    // Why not start with start?
    // Because start has a different job.
    //   ➊ end expands the window.
    //   ➊ start shrinks the window.
    // Imagine you're stretching a rubber band.
    // start ---------------- end
    // You first stretch it to include more characters.
    // Only when a duplicate appears do you move the left side (start) forward.

    private static int lengthOflongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int ans = 0;

        Set<Character> set = new LinkedHashSet<>();
        while(end < s.length()) {
            char c = s.charAt(end);
            if(!set.contains(c)) {
                set.add(c);
                end++;
                ans = Math.max(ans, set.size());
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }

        return ans;
        // return set.toString();
    }
}
