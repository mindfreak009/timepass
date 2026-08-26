package shashcode30;

// Difficulty: Easy
// =================

// Given a string s of zeros and ones, return the maximum score after splitting the string into
// two non-empty substrings (i.e. left substring and right substring).

// The score after splitting a string is the number of zeros in the left substring plus the number
// of ones in the right substring.

// Example 1:
// Input: s = "011101"
// Output: 5
// Explanation:
// All possible ways of splitting s into two non-empty substrings are:
// left = "0" and right = "11101", score = 1 + 4 = 5
// left = "01" and right = "1101", score = 1 + 3 = 4
// left = "011" and right = "101", score = 1 + 2 = 3
// left = "0111" and right = "01", score = 1 + 1 = 2
// left = "01110" and right = "1", score = 2 + 1 = 3

// Example 2:
// Input: s = "00111"
// Output: 5
// Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5

// Example 3:
// Input: s = "1111"
// Output: 3

// Constraints:
// 2 <= s.length <= 500
// The string s consists of characters '0' and '1' only.

public class MaximumScoreAfterSplittingAString {
    public static void main(String[] args) {
        String s = "011101";
        // System.out.println(maxScore(s));
        System.out.println(maxScore_Improved(s));
    }

    // Time Complexity: O(N) + O(N)
    public static int maxScore(String str) {

        // find all ones
        int ones = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if(str.charAt(i) == '1') ones++;
        }

        // find max partition
        int res = 0;
        int zeros = 0;
        for (int i = 0; i < n-1; i++) {
            if(str.charAt(i) == '0') zeros++;
            else ones--;
            res = Math.max(res, zeros + ones);
        }
        return res;
    }

    // Time Complexity: O(N)
    public static int maxScore_Improved(String str) { // 011101

        int ones = 0;
        int zeros = 0;
        int n = str.length();

        // find max partition
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < n-1; i++) {
            if(str.charAt(i) == '0') zeros++;
            else ones++;
            maxDiff = Math.max(maxDiff, zeros - ones);
        }
        if (str.charAt(n-1) == '1') ones++;
        return (maxDiff + ones);
    }
}
