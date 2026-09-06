package leetcode;

// Difficulty: Medium
// You are given two Strings 'P' and 'Q' of equal length.
// Your task is to return 1 if String 'P' can be converted into String 'Q' by cyclically rotating it to the right any number of times ( Possibly Zero ), else return 0.

// A cyclic rotation to the right on String 'A' consists of taking String 'A' and moving the rightmost character to the leftmost position. For example, if 'A' = "pqrst", then it will be "tpqrs" after one cyclic rotation on 'A'.

// For example:
// Consider the two strings 'P' = "abfyg" and 'Q' = "gabfy"
// If we cyclically rotate String 'P' to the right once. The resulting string P becomes "gabfy" which is equal to String 'Q'.
// Therefore,  it is possible to convert String 'P' to String 'Q'.

// Sample Input 1:
//    • abac
//    • baca
// Sample Output 1: 1

// Explanation For Sample Input 1:
// Let's try rotating the String 'P' to the right and try all the possible rotations:
//   1) If we rotate "abac" to the right, the resulting string becomes "caba".
//   2) If we rotate "caba" to the right, the resulting string becomes "acab".
//   3) If we rotate "acab" to the right, the resulting string becomes "baca" which is equal to String 'Q'.

// Therefore, it is possible to convert String 'P' to String 'Q'. Hence, we will return 1 in this case.

// Sample Input 2:
//   • aabca
//   • bacaa
// Sample Output 2: 0

// Constraints:
//    • 1 <= |P| , |Q| <= 10^5
//    • |P| = |Q|
// String 'P' and 'Q' have the same length and contain only lowercase English letters.
//
// Time Limit: 1 sec
// Follow Up:
// Can you solve this in O(N) time?

public class CheckIfOneStringIsARotationOfAnother {
    public static void main(String[] args) {
        String s = "abfyg";  // abfygabfyg
        String q = "gabfy";
        System.out.println(isCyclicRotation(s, q));
        System.out.println(isCyclicRotation1(s, q));
    }

    // Time Complexity:
    //   • (p + p) → O(N)
    //   • contains(q) → commonly analyzed as O(N × N) = O(N²) in the worst case for a straightforward substring search.
    //   • Total → O(N²) worst case.
    public static int isCyclicRotation(String p, String q)  {
        // edge case
        if(p.length() != q.length()) return 0;

        return (p+p).contains(q) ? 1: 0;
    }

    public static int isCyclicRotation1(String p, String q) {
        int n = p.length();

        // Same length is already guaranteed, but keeping this
        // check makes the method complete.
        if (n != q.length()) {
            return 0;
        }

        // Q must occur inside P + P
        String text = p + p;

        return kmpSearch(text, q) ? 1 : 0;
    }

    private static boolean kmpSearch(String text, String pattern) {
        int[] lps = buildLPS(pattern);

        int i = 0; // text pointer
        int j = 0; // pattern pointer

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == pattern.length()) {
                    return true;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return false;
    }

    private static int[] buildLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i] = ++len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }

}
