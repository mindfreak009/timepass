package dsa.sliding_window;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_1 {
    public static void main(String[] args) {
        // String str = "abcabcbb";
        String str = "pwwkew"; // output: wke

        // System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfLongestSubstringAlongWithString(str));

    }
    private static int lengthOfLongestSubstring(String str) {
        int left = 0;
        int right = 0;

        Set<Character> seen = new LinkedHashSet<>();
        int max = 0;

        while(right < str.length()) {
            char c = str.charAt(right);
            if(seen.add(c)) {
                max = Math.max(max, right-left + 1);
                right++;
            } else {
                while(str.charAt(left) != c) {
                    seen.remove(str.charAt(left));
                    left++;
                }
                seen.remove(c);
                left++;
            }
        }
        return  max;
    }

    private static String lengthOfLongestSubstringAlongWithString(String str) {
        int start = 0;
        int end = 0;
        int len = str.length();

        int maxLength = 0;
        int maxStart = 0;

        Set<Character> set = new HashSet<>();

        while(end < len) {
            char ch = str.charAt(end);
            if(!set.contains(ch)) {
                set.add(ch);
                end++;

                // Current window length
                int currLen = end - start;

                // Is this the longest so far ?
                if (currLen > maxLength) {
                    maxLength = currLen;
                    maxStart = start;
                }
            } else {
                set.remove(str.charAt(start));
                start++;
            }
        }
        return str.substring(maxStart, maxStart+maxLength);
    }
}
