package leetcode;

import java.util.HashMap;
import java.util.Map;

// EASY LEVEL QUESTION

// Input: s = "leetcode"
// Output: 0

// Input: s = "loveleetcode"
// Output: 2

// Input: s = "aabb"
// Output: -1
public class FistUniqueCharacterInAString {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqueCharacterInString(s));
    }

    public static long firstUniqueCharacterInString(String s) {
        Map<Character, Long> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            } else {
                map.put(ch, 1L);
            }
        }

        System.out.println(map);
        for (int i = 0; i < s.length(); i++) {
            Long j = map.get(s.charAt(i));
            if(j == 1) {
                // return map.get(i);
               return i;
            }
        }
        // return map.getOrDefault(-1, Long.valueOf(-1));
        return -1;
    }
}
