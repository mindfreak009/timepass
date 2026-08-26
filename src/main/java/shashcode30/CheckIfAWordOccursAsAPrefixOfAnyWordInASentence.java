package shashcode30;

// Given a sentence that consists of some words separated by a single space, and a searchWord,
// check if searchWord is a prefix of any word in sentence.
// Return the index of the word in sentence (1-indexed) where searchWord is a prefix of this word.
// If searchWord is a prefix of more than one word, return the index of the first word (minimum index).
// If there is no such word return -1.
// A prefix of a string s is any leading contiguous substring of s.

// Input: sentence = "i love eating burger", searchWord = "burg"
// Output: 4
// Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.

// Example 2:
// Input: sentence = "this problem is an easy problem", searchWord = "pro"
// Output: 2
// Explanation: "pro" is prefix of "problem" which is the 2nd and the 6th word in the sentence,
// but we return 2 as it's the minimal index.

// Example 3:
// Input: sentence = "i am tired", searchWord = "you"
// Output: -1
// Explanation: "you" is not a prefix of any word in the sentence.

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    public static void main(String[] args) {
      //  String sentence = "i love eating burger";
      //  String searchWord = "burg";
        String sentence = "this problem is an easy problem";
        String searchWord = "pro";
        System.out.println(isPrefixOfWord(sentence, searchWord));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String words[] = sentence.split(" ");
        int splitWordsLength = words.length;

        int m = searchWord.length();

        int firstOccurence = -1;
        int lastOccurence = -1;
        for (int i = 0; i < splitWordsLength; i++) {
            if(words[i].length() >= searchWord.length()) {
                if((words[i].substring(0, m).equals(searchWord))) {
                    // If it's the first occurrence, store the index
                    // We are adding (i+1), since we are
                    if (firstOccurence == -1) {
                        firstOccurence = i + 1; // 1-indexed
                    }

                }
                // Update the last occurrence every time we find a match
                lastOccurence = i + 1; // 1-indexed
            }

        }
        System.out.println(firstOccurence + " : " +  lastOccurence);

        if(firstOccurence > 0 && lastOccurence > 0) {
            return Math.min(firstOccurence, lastOccurence);
        }

        return -1;

    }
}
