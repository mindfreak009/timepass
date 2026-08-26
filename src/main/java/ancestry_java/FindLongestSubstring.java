package ancestry_java;

import java.util.LinkedHashSet;
import java.util.Set;

public class FindLongestSubstring {
    public static void main(String[] args) {
        String str = "abcabfcd";
        System.out.println(findLongestSubstring(str));
    }

    private static String findLongestSubstring(String str) {
        int start = 0;
        int len = str.length();
        int end = 0;

        Set<Character> set = new LinkedHashSet<>();

        while(end < len) {
            char ch = str.charAt(end);
            if(!set.contains(ch)) {
                set.add(ch);
                end++;
            } else {
                set.remove(str.charAt(start));
                start++;
                //count= 0;
            }
        }

        return set.toString();
    }
}
