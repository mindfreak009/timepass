package interview_ques.acuverconsulting;

import java.util.Arrays;
import java.util.List;

// Output: OBIKJEA
public class ReverseOnlyVowelsFromAString {
    public static void main(String[] args) {
        String str = "ABEKJIO";
        // String str = "AEkj";
        System.out.println("Final Output :: " + reverseOnlyVowelsInString2(str));
    }

    private static String reverseOnlyVowelsInString(String str) {

        StringBuilder vowelList = new StringBuilder();
        String vowels = "AEIOUaeiou";

        // Collect the vowels in the original string
        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                vowelList.append(c);
            }
        }
        System.out.println("vowelList before reversing :: " + vowelList);

        // Step 2: Reverse the vowels
        vowelList.reverse();
        System.out.println("vowelList after reversing :: " + vowelList);

        // Step 3: Replace the vowels in the original string with reversed vowels
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;

        for (char c : str.toCharArray()) {
            if(vowels.indexOf(c) != -1) {
                // Replace with a vowel from the reversed list
                result.append(vowelList.charAt(vowelIndex));
                vowelIndex++;
            } else {
                // Keep non-vowel characters the same
                result.append(c);
            }
        }
        return result.toString();
    }

    // Time Complexity = O(N)
    // Space Complexity = O(N)
    private static String reverseOnlyVowelsInString2(String str) {

        List<Character> vowelsList = Arrays.asList('A', 'E', 'I', 'O', 'U');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(vowelsList.contains(ch)) {
                sb.append(ch);
            }
        }
        System.out.println("Before reverse : " + sb);
        sb.reverse();
        System.out.println("After reverse : " + sb);

        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
             // Replace with a vowel from the reversed list
            if(vowelsList.contains(ch)) {
                result.append(sb.charAt(vowelIndex++));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

}
