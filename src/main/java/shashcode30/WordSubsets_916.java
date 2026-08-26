package shashcode30;

// You are given two string arrays words1 and words2.
// A string b is a subset of string a if every letter in b occurs in a including multiplicity.

// For example, "wrr" is a subset of "warrior" but is not a subset of "world".
// A string a from words1 is universal if for every string b in words2, b is a subset of a.
// Return an array of all the universal strings in words1. You may return the answer in any order.

// Example 1:
// Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
// Output: ["facebook","google","leetcode"]

// Example 2:
// Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
// Output: ["apple","google","leetcode"]

// Constraints:
//     1 <= words1.length, words2.length <= 104
//     1 <= words1[i].length, words2[i].length <= 10
//     words1[i] and words2[i] consist only of lowercase English letters.
//     All the strings of words1 are unique.


import java.util.ArrayList;
import java.util.List;

public class WordSubsets_916 {
    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"},  words2 = {"e","o"};
        System.out.println(wordSubsets(words1, words2));
    }
    public static List<String> wordSubsets(String[] words1, String[] words2) {

        int freq[] = new int[26];
        for(String word : words2){ //M
            int temp[] = getFreq(word); //p
            for(int i=0;i<26;i++){ //26
                freq[i] = Math.max(freq[i], temp[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for(String word : words1){ //n
            int temp[] = getFreq(word); //p
            boolean flag=true;
            for(int i=0;i<26;i++){ //26
                if(freq[i] > temp[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res.add(word);
            }
        }
        return res;
    }
    public static int[] getFreq(String word){
        int freq[] = new int[26];
        for(int i=0;i<word.length();i++){
            freq[word.charAt(i) - 'a']++;
        }
        return freq;
    }
}
