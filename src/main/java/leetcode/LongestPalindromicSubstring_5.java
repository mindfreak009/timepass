package leetcode;

// Difficulty: Medium

// Given a string s, return the longest palindromic substring in s.

// Example 1:
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.

// Example 2:
// Input: s = "cbbd"
// Output: "bb"

// Constraints:
// 1 <= s.length <= 1000
// s consist of only digits and English letters.

public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {
        //String s = "EBBABAD";
        String s = "CBEEREED";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String str) {
        if(str.length() <=1) {
            return str;
        }

        String lps = "";

        for (int i = 1; i < str.length(); i++) {

            // consider odd length
            int low = i;
            int high = i;

            // keep extending in both left and right directions till the conditions for a palindrome are met
            while(str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                // Terminating condition if we reach the end/start of string
                if (low == -1 || high == str.length())
                    break;
            }

                // indexes low and high can be used to extract the substring
                String palindrome = str.substring(low+1, high);
                if(palindrome.length() > lps.length()) {
                    lps = palindrome;
                }


                // Consider even length
                low = i-1;
                high = i;
                while(str.charAt(low) == str.charAt(high)) {
                    low--;
                    high++;

                    if(low == -1 || high == str.length())
                        break;
                }

                palindrome = str.substring(low+1, high);
                if(palindrome.length() > lps.length()) {
                    // Similarly, keeps a track of longest even length palindrome
                    lps = palindrome;
                }
        }
        return lps;
    }
}
