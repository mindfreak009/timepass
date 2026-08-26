package leetcode;


// Difficulty: Medium
// Leetcode Ques: 3941

// You are given a string password.

// The strength of the password is calculated based on the following rules:
// 1 point for each distinct lowercase letter ('a' to 'z').
// 2 points for each distinct uppercase letter ('A' to 'Z').
// 3 points for each distinct digit ('0' to '9').
// 5 points for each distinct special character from the set "!@#$".
// Each character contributes at most once, even if it appears multiple times.

// Return an integer denoting the strength of the password.


import java.util.HashSet;
import java.util.Set;

public class PasswordStrength {
    public static void main(String[] args) {
        // String password = "bbB11#";
        // String password = "aA1!";
        String password = "vqztn2Z";
        System.out.println(passwordStrength(password));
    }

    public static int passwordStrength(String password) {
        int totalCount = 0;

        if(password == null || password.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<>();

        for(int i=0; i<password.length(); i++) {
            char ch = password.charAt(i);

            if (!set.add(ch)) {
                continue; // already processed
            }

            if(Character.isDigit(ch)) {
                set.add(ch);
                totalCount+= 3;
            } else if(Character.isUpperCase(ch)) {
                set.add(ch);
                totalCount+= 2;
            } else if(Character.isLowerCase(ch)) {
                set.add(ch);
                totalCount+= 1;
            } else {
                set.add(ch);
                totalCount+= 5;
            }
        }
        return totalCount;
    }
}
