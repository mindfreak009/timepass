package dsa.sliding_window;

// Given a string s consisting only of characters a, b and c.
// Return the number of substrings containing at least one occurrence of all these characters a, b and c.

// Example 1:
// Input: s = "abcabc"
// Output: 10
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are:
// "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).

// Example 2:
// Input: s = "aaacb"
// Output: 3
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".

// Example 3:
// Input: s = "abc"
// Output: 1

// Constraints:
//    3 <= s.length <= 5 x 10^4
//    s only consists of a, b or c characters.

public class NumberOfSubstringsContainingAllThreeCharacters_1358 {
    public static void main(String[] args) {
        String str = "abcabc";
        System.out.println(numberOfSubstrings(str));
    }

    public static int numberOfSubstrings(String str) {
        int[] freq = new int[3];
        int count = 0;
        int currCount = 0;
        int left = 0;
        int n = str.length();
        for (int right = 0; right < str.length() ; right++) {
            char ch = str.charAt(right);
            freq[ch - 'a']++;
            if(freq[ch - 'a'] == 1) {
                currCount++;

            }

            while(currCount == 3){
                count += (n-right);
                char c = str.charAt(left);
                freq[c -'a']--;
                if(freq[c - 'a'] == 0) {
                    currCount--;
                }
                left++;
            }
        }

        return count;

    }
}
