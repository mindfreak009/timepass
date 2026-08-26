package interview;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters111 {
    public static void main(String[] args) {
        // String s = "abcabcbb";
        // String s = "bbbbb";
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int ans = 0;

        while (end < s.length()) {
            char c = s.charAt(start);
            if(!set.contains(c)) {
                set.add(c);
                start++;
                ans++;
            } else {
                set.remove(end);
                ans = Math.max(set.size(), ans);
                end++;
            }
        }
        return ans;
    }
}
