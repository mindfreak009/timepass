package interview_ques;

import java.util.ArrayList;
import java.util.List;


// Time Complexity : O(N)
// Space Complexity : O(1)

public class MaximumBalancedStringPartitions_Walmart {
    public static void main(String[] args) {
        String input = "RLRRLLRLRL";
        // String input = "LLLLRRRR";

        List<String> stringList = balancedStringSplit(input);
        System.out.println("Size is :: " + stringList.size() + stringList);
    }

    public static List<String> balancedStringSplit(String s) {
        int balance = 0;        // A variable to track the balance between 'L' and 'R' characters

        List<String> subArrayList = new ArrayList<>();
        StringBuilder currentSubstring = new StringBuilder();

        // Loop through each character in the string
        for (char ch : s.toCharArray()) {
            // Increment balance when 'L' is found
            if (ch == 'L') {
                balance++;
                // Decrement balance when 'R' is found
            } else if (ch == 'R') {
                balance--;
            }

            currentSubstring.append(ch);

            // When balance is zero, a balanced string is found
            if (balance == 0) {
                subArrayList.add(currentSubstring.toString());
                currentSubstring.setLength(0);
            }
        }

        // Return the total number of balanced strings
        // return balanceCount;
        return subArrayList;
    }

}
