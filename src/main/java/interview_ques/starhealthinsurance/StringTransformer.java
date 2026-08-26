package interview_ques.starhealthinsurance;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// interchange 'r' with 'o' and vice versa AND  replace 'f' with 't' and vice versa, if you encounter r and o in same word.
public class StringTransformer {
    public static void main(String[] args) {
        String input = "ram is a good person though he does not like shyam as he works in different project arbossfit";
        String output = transformString(input);
        System.out.println(output);
    }

    public static String transformString(String input) {
        // Split the input string into words
        List<String> words = Arrays.asList(input.split(" "));
        System.out.println("words here :: " +words);

        // Process each word
        List<String> transformedWords = words.stream()
                                            .map(StringTransformer::transformWord)
                                            .collect(Collectors.toList());

        // Join the words back into a single string
        return String.join(" ", transformedWords);
    }

    private static String transformWord(String word) {
        // Check if 'r' and 'o' OR 'f' and 't' are both present in the word
        boolean containsRO = word.contains("r") && word.contains("o");
        boolean containsFT = word.contains("f") && word.contains("t");

        // If either pair is present, apply the transformation
        StringBuilder transformed = new StringBuilder();

        if(containsRO && containsFT) {
            for (char c : word.toCharArray()) {
                if (c == 'r') {
                    transformed.append('o');
                } else if (c == 'o') {
                    transformed.append('r');
                } else if (c == 'f') {
                    transformed.append('t');
                } else if (c == 't') {
                    transformed.append('f');
                } else {
                    transformed.append(c);  // No transformation for other characters
                }
            }
            return transformed.toString();
        } else if (containsRO) {
            for (char c : word.toCharArray()) {
                if (c == 'r') {
                    transformed.append('o');
                } else if (c == 'o') {
                    transformed.append('r');
                } else {
                    transformed.append(c);  // No transformation for other characters
                }
            }
            return transformed.toString();
        } else if(containsFT) {
            for (char c : word.toCharArray()) {
                if (c == 'f') {
                    transformed.append('t');
                } else if (c == 't') {
                    transformed.append('f');
                } else {
                    transformed.append(c);  // No transformation for other characters
                }
            }
            return transformed.toString();
        } else {
            return word;  // No transformation if no valid pair is present
        }

    }
}

