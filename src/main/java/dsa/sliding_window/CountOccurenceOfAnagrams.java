package dsa.sliding_window;

// Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.
// Example 1:

// Input: txt = "forxxorfxdofr", pat = "for"
// Output: 3
// Explanation: for, orf and ofr appears in the txt, hence answer is 3.

// Example 2:
// Input: txt = "aabaabaa", pat = "aaba"
// Output: 4
// Explanation: aaba is present 4 times in txt.

// Constraints:
// 1 <= |pat| <= |txt| <= 105
// Both strings contain lowercase English letters.

import java.util.Arrays;
import java.util.Stack;

public class CountOccurenceOfAnagrams {
    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        //System.out.println(countOccurenceOfAnagrams(txt, pat));
        System.out.println(searchOccurenceOfAnagrams(txt, pat));
        //System.out.println(searchOccurenceOfAnagrams2(txt, pat));
    }


    // Shashwat logic
    // Time Complexity: O(K) + O(K + N-K) * O(26)    because O(26) is constant here, so striked out
    //                  O(K + N)
    public static int searchOccurenceOfAnagrams2(String txt, String pat){
        int k = pat.length();
        int n = txt.length();

        // Calc Pattern Freq
        int[] patFreq = new int[26];
        for (int i = 0; i < k; i++) {
            int index = pat.charAt(i)-97;
            patFreq[index]++;
        }

        // init windows
        int[] textFreq = new int[26];
        for (int i = 0; i < k; i++) {
            int index = txt.charAt(i)-97;
            textFreq[index]++;
        }

        int count = 0;
        if(Arrays.equals(textFreq, patFreq)) {
            count++;
        }

        // sliding window
        for (int i = 1; i < n-k+1 ; i++) {
            int removedCharIndex = txt.charAt(i-1)-97;
            int addedCharIndex = txt.charAt(i+k-1)-97;
            textFreq[addedCharIndex]++;
            textFreq[removedCharIndex]--;
            if(Arrays.equals(textFreq, patFreq)) {
                count++;
            }
        }
        return count;
    }

    public static int searchOccurenceOfAnagrams(String txt, String pat) {
        int k = pat.length();
        int n = txt.length();

        int[] patFreq = new int[26];
        int[] textFreq = new int[26];

        // Pattern frequency
        for (int i = 0; i < k; i++) {
            patFreq[pat.charAt(i) - 'a']++;
            textFreq[txt.charAt(i) - 'a']++;
        }

        int count = 0;
        if (Arrays.equals(patFreq, textFreq)) {
            count++;
        }

        // Sliding window
        for (int i = k; i < n; i++) {
            textFreq[txt.charAt(i) - 'a']++;          // add new char
            textFreq[txt.charAt(i - k) - 'a']--;      // remove old char

            if (Arrays.equals(patFreq, textFreq)) {
                count++;
            }
        }

        return count;
    }

    public static int countOccurenceOfAnagrams(String txt, String pat) {
        int start = 0;
        int end = 0;
        int k = pat.length();

        int counter = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(pat.charAt(i));
        }

        for (int i = 0; i < txt.length() ; i++) {
            char c = txt.charAt(i);
            if(!stack.isEmpty() && stack.contains(c)) {

                counter++;
            }
        }

        return 0;
    }
}
