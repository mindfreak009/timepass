package shashcode30;

// Difficulty: Easy

// Given an array of string words, return all strings in words that is a substring of another word.
// You can return the answer in any order.

// A substring is a contiguous sequence of characters within a string.

// Example 1:
// Input: words = ["mass","as","hero","superhero"]
// Output: ["as","hero"]
// Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
// ["hero","as"] is also a valid answer.

// Example 2:
// Input: words = ["leetcode","et","code"]
// Output: ["et","code"]
// Explanation: "et", "code" are substring of "leetcode".

// Example 3:
// Input: words = ["blue","green","bu"]
// Output: []
// Explanation: No string of words is substring of another string.

// Constraints:

//     1 <= words.length <= 100
//     1 <= words[i].length <= 30
//     words[i] contains only lowercase English letters.
//     All the strings of words are unique.

import java.util.ArrayList;
import java.util.List;

public class StringMatchingInAnArray_1408 {
    public static void main(String[] args) {
       // String[] words = {"mass","as","hero","superhero"}; // Output: [as, hero]
        String[] words = {"blue","green","bu"};  // Output: []
        System.out.println(stringMatching(words));
    }
    // time Complexity : O(N^2) * m * n
    public  static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(i==j) continue;
                if(words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
}
