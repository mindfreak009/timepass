package dsa.strings;

// Topics: Two Pointer, String

// Given a string s, reverse only all the vowels in the string and return it.
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

// Example 1:
// Input: s = "IceCreAm"
// Output: "AceCreIm"
// Explanation:
// The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

// Example 2:
// Input: s = "leetcode"
// Output: "leotcede


// Time complexity : O(N)
// Space Complexity : O(1)
public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        //String str = "leetcode";
        String str = "IceCreAm";
        String result = reverseVowelsOfAString(str);
        System.out.println("Final Answer :: " +result);
    }

    private static String reverseVowelsOfAString(String str) {
        char[] ch = str.toCharArray();
        int len = str.length();
        int start = 0;
        int end = len -1;

        while(start < end) {
            if(!isVowel(ch[start])) {
                start++;
            } else if(!isVowel(ch[end])) {
                end--;
            } else {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        return String.valueOf(ch);

    }

    private static boolean isVowel(char ch) {
        if(ch=='a' ||  ch=='e' || ch=='i' || ch=='o' || ch=='u'
                || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
            return true;
        }
        return false;
    }
}
