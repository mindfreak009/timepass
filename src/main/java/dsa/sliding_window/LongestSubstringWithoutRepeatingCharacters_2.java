package dsa.sliding_window;

// Given a string s, find the length of the longest substring without repeating characters.

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc",  with teh length of 3.


// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_2 {
    public static void main(String[] args) {

      //  String s = "abcabcbb";
       // String s = "bbbbb";
        String s =  "pwwkew";
        int i = longestSubstringWithoutRepeatingCharacters(s);
        System.out.println(i);
    }

    private static int longestSubstringWithoutRepeatingCharacters(String s) {
        int windowStart = 0;
        int windowEnd = 0;

        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;

        while(windowEnd < n) {
            char ch = s.charAt(windowEnd);
           // if(hashSet.contains(ch)) {
            if(map.containsKey(ch) && map.get(ch) >= windowStart) {
                // shrinking
//                while(windowStart < windowEnd && map.contains(ch)) {
//                    hashSet.remove(s.charAt(ch));
//                    windowStart++;
//                }
                windowStart = map.get(ch)+1;
            }

            map.put(ch, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            windowEnd++;
        }

        return (maxLength==Integer.MIN_VALUE)?0:maxLength;
    }
}
