package dsa.strings;

public class MatchingSubstring {

    // Function to find the length of the longest matching substring
    public static int findMatchingSubstringLength(String str1, String str2, int k) {
        // Initialize variable to track the maximum length of valid substring
        int maxLength = 0;

        // Iterate over all possible start positions for substrings
        for (int start = 0; start < str1.length(); start++) {
            for (int end = start; end < str1.length(); end++) {
                // Check if the substring from start to end is valid
                boolean isValid = true;

                // Compare characters between str1 and str2
                for (int i = start; i <= end; i++) {
                    if (Math.abs(str1.charAt(i) - str2.charAt(i)) > k) {
                        isValid = false;
                        break;
                    }
                }

                // If the substring is valid and its length is greater than the previous maximum valid substring length
                if (isValid && (end - start + 1 > maxLength)) {
                    maxLength = end - start + 1;
                }
            }
        }

        // Return the length of the longest matching substring
        return maxLength;
    }

    public static void main(String[] args) {
        // Example input
        String str1 = "abmqt";
        String str2 = "bcxsz";
        int k = 4;

        // Call the function to find the length of the matching substring
        int result = findMatchingSubstringLength(str1, str2, k);

        // Output the result
        System.out.println("The length of the matching substring is: " + result);
    }
}

