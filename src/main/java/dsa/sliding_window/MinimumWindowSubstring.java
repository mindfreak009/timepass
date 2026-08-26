package dsa.sliding_window;

// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
// every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.
// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

// Example 2:
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.

// Example 3:
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.

// Constraints:
// m == s.length
// n == t.length
// 1 <= m, n <= 10^5
// s and t consist of uppercase and lowercase English letters.

import java.util.HashMap;

// time Complexity: O(M + 2N) = O(M+N)
// Space Complexity: O(M)
public class MinimumWindowSubstring {
    public static void main(String[] args) {
       //  String s = "ADOBECODEBANC";
       //  String t = "ABC";
        String s = "a";
        String t = "aa";
        System.out.println(minimumWindowSubstring(s, t));
    }

    public static String minimumWindowSubstring(String s, String t) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        // populate the map with t string
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }
        int uniqueCharCount = freqMap.size();
        int startIndex = -1;
        int windowStart = 0;
        int windowEnd = 0;
        int minLen = Integer.MAX_VALUE;
        int n = s.length();

        while(windowEnd < n) {
            // Expansion phase
            char ch = s.charAt(windowEnd);
            if(freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch)-1);
                if(freqMap.get(ch) == 0){
                    uniqueCharCount--;
                }
            }

            // Shrinking phase
            while(uniqueCharCount == 0){
                // find len
                int len = windowEnd - windowStart + 1;
                if(len < minLen){
                    minLen = len;
                    startIndex = windowStart;
                }
                ch = s.charAt(windowStart);
                if(freqMap.containsKey(ch)) {
                    freqMap.put(ch, freqMap.get(ch)+1);
                    if(freqMap.get(ch) > 0){
                        uniqueCharCount++;
                    }
                }
                windowStart++;
            }
            windowEnd++;
        }

        if(startIndex == -1){
            return "";
        }
        return s.substring(startIndex, startIndex + minLen);
    }
}


