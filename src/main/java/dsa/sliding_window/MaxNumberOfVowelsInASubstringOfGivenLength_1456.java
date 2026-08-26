package dsa.sliding_window;

// Given a string s and an integer k, return the maximum number of vowel letters in any substring
// of s with length k.
// Vowel letters are :  'a', 'e', 'i', 'o', 'u'

// Input  : "abciiidef", k=3
// Output : 3
// Explanation : The substring "iii" contains 3 vowel letters.

// Input  : "aeiou", k=2
// Output : 3
// Explanation : The substring "iii" contains 3 vowel letters.


public class MaxNumberOfVowelsInASubstringOfGivenLength_1456 {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    private static int maxVowels(String s, int k) {
        int left = 0, right = 0, res = 0, window = 0;
        for(; right < k; right++) {
            window += isVowel(s.charAt(right));
        }

        res = window;
        while(right < s.length()) {
            window -= isVowel(s.charAt(left++));
            window += isVowel(s.charAt(right++));
            res = Math.max(res, window);
        }
        return  res;
    }

    private static int isVowel(char c) {
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') ? 1 : 0;
    }
}
