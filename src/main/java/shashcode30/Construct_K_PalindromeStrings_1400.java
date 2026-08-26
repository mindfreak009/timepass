package shashcode30;

// Difficulty : Medium

// Given a string s and an integer k, return true if you can use all the characters in s to construct k palindrome strings or false otherwise.

// Example 1:
// Input: s = "annabelle", k = 2
// Output: true
// Explanation: You can construct two palindromes using all characters in s.
// Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"

// Example 2:
// Input: s = "leetcode", k = 3
// Output: false
// Explanation: It is impossible to construct 3 palindromes using all the characters of s.

// Example 3:
// Input: s = "true", k = 4
// Output: true
// Explanation: The only possible solution is to put each character in a separate string.

// Constraints:
//     1 <= s.length <= 105
//     s consists of lowercase English letters.
//     1 <= k <= 105


import java.util.HashMap;
import java.util.Map;

public class Construct_K_PalindromeStrings_1400 {
    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;
        System.out.println(canConstruct(s, k));
        System.out.println(canConstruct2(s, k));
    }

    public static boolean canConstruct(String str, int k) {
        int n = str.length();
        if(n < k) return false;
        // if both length are same, no need to calculate anything, simply return true;
        if(n == k) return true;

        // find freq
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            count[str.charAt(i) - 'a']++;
        }

        int c = 0;
        // find odd count
        for (int i = 0; i < 26; i++) {
            if(count[i]%2 != 0) c++;
        }

        return (c<=k);
    }

    public static boolean canConstruct2(String s, int k) {
        if(k>s.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        System.out.println("map :: " + map);

        int count=0;
        for(Map.Entry<Character,Integer> finalMap : map.entrySet()){
            if(finalMap.getValue()%2 !=0){
                count++;
            }
        }

        System.out.println("count :: " +count);

        if(count>k){
            return false;
        }
        return true;
    }
}
