package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindIndexOfFirstOcurenceOfString {
    public static void main(String[] args) {

        // String haystack = "sadbutsad";
        String haystack = "butsad";
        String needle = "sad";

//        String haystack = "leetcode";
//        String needle = "leeto";


        System.out.println(strStr(haystack, needle));

    }

    public static int strStr(String haystack, String needle) {

        if (needle.isEmpty()) {
            return 0; // An empty needle is always present at index 0.
        }

        int hayLen = haystack.length();
        int needleLen = needle.length();

        for (int i = 0; i <= hayLen - needleLen; i++) {
            int j;
            for (j = 0; j < needleLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break; // Characters don't match, move to the next position in haystack.
                }
            }
            if (j == needleLen) {
                return i; // All characters in needle matched, found a match.
            }
        }

        return -1; // No match found.
    }
}
