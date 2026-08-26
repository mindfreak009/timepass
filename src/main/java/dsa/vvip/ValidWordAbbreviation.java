package dsa.vvip;

// A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths.
// The lengths should not have leading zeros

// For example, a string such as "substitution" could be abbreviated as (but not limited to):
// "s10n" ("s ubstitutio n")
// "sub4u4" ("sub stit u tion")
// "12" ("substitution")
// "su3i1u2on" ("su bst i t u ti on")
// "substitution" (no substrings replaced)

// Input: word = "internationalization", abbr = "i12iz4n"
// Output: true
// Explanation: The word "internationalization" can be abbreviated as "i12iz4n" ("i nternational iz atio n")

public class ValidWordAbbreviation {
    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "i12iz4n";

        validWordAbbreviation(word, abbr);
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length(), n = abbr.length();
        int i = 0, j=0;
        while (i<word.length() && j<abbr.length()) {
            ++i;
            ++j;
        }

        return false;
    }
}
