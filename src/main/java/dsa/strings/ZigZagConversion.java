package dsa.strings;


// LeetCode Ques: 6
// Difficulty: Medium

// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//  P   A   H   N
//  A P L S I I G
//  Y   I   R

// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:
//   string convert(string s, int numRows);

// Example 1:
// Input: s = "PAYPALISHIRING", numRows = 3
// Output: "PAHNAPLSIIGYIR"

// Example 2:
// Input: s = "PAYPALISHIRING", numRows = 4
// Output: "PINALSIGYAHRPI"
// Explanation:
//    P     I    N
//    A   L S  I G
//    Y A   H R
//    P     I

// Example 3:
// Input: s = "A", numRows = 1
// Output: "A"

// Constraints:
//  ●  1 <= s.length <= 1000
//  ●  s consists of English letters (lower-case and upper-case), ',' and '.'.
//  ●  1 <= numRows <= 1000

import java.util.Arrays;

public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {

        // edge case
        if(numRows ==1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int circle = (numRows*2) - 2;

        for (int i = 0; i < s.length(); i++) {
            int index = i % circle;
            System.out.println("index:: " +index);

            if(index >= numRows) {
                index = circle - index;
            }
            rows[index].append(s.charAt(i));
            System.out.println("rows now ::" + Arrays.toString(rows));
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }

        return sb.toString();
    }
}
