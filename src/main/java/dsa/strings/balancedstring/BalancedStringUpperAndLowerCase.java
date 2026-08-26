package dsa.strings.balancedstring;

// A string is called balanced when every letter occuring in the string appears both in upper and lowercase.
// For eg.., the string "CATattac" is balanced ('a', 'c' and 't' occur in both cases), but 'Madam' is not
//            'd' and 'a' appear only in lowercase).

// Note: The number of occurences does not matter.

// Example 1:
// Given S = "azABaabza" the function should return 5. The shortest balanced fragment of S is "ABaab"

// Example 2:
// Given S = "TacoCat", the function should return -1. There is no balanced fragment.

// Example 3:
// Given S = "AcZCbaBz" the function should return 8. The shortest balanced fragment is the whole string

// Example 4:
// Given S = "abcdefghijklmnopqrstuvwxyz" the function should return -1.

// Assume that :
//    N is an integer within the range [1...200]
//    string S consists of only letters ('a'-'z' and/or 'A'or'Z')

import java.util.*;

//
public class BalancedStringUpperAndLowerCase {
    public static void main(String[] args) {
        String str = "azABaabza";
        System.out.println(lengthOfShortestBalancedSubstring(str));  // Output: 5 ("ABaab")

        str = "TacoCat";
        System.out.println(lengthOfShortestBalancedSubstring(str));  // Output: -1 (No balanced substring)

        str = "AcZCbaBz";
        System.out.println(lengthOfShortestBalancedSubstring(str));  // Output: 8 ("AcZCbaBz")

        str = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(lengthOfShortestBalancedSubstring(str));  // Output: -1 (No balanced substring)

    }

    public static int lengthOfShortestBalancedSubstring(String str) {
        int minLength = Integer.MAX_VALUE;

        // Sliding window approach
        for (int start = 0; start < str.length(); start++) {
            Set<Character> lowerCaseSet = new HashSet<>();
            Set<Character> upperCaseSet = new HashSet<>();

            for (int end = start; end < str.length(); end++) {
                char c = str.charAt(end);

                // Add to the corresponding set (lower or upper)
                if (Character.isLowerCase(c)) {
                    lowerCaseSet.add(c);
                } else {
                    upperCaseSet.add(c);
                }

                // Check if the window is balanced
                if (isBalanced(lowerCaseSet, upperCaseSet)) {
                   // System.out.println("start :: " +start);
                   // System.out.println("end :: " +end);
                    minLength = Math.min(minLength, end - start+1);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;  // Return -1 if no balanced substring was found
    }

    private static boolean isBalanced(Set<Character> lowerCaseSet, Set<Character> upperCaseSet) {
        // A window is balanced if every lowercase character has its corresponding uppercase counterpart
        for (char c : lowerCaseSet) {
            if (!upperCaseSet.contains(Character.toUpperCase(c))) {
                return false;
            }
        }
        for (char c : upperCaseSet) {
            if (!lowerCaseSet.contains(Character.toLowerCase(c))) {
                return false;
            }
        }
        return true;
    }
}





//    private static int checkBalancedStringUpperAndLowerCase(String str) {
//        List<Character> smallCase = Arrays.asList('a','b','c','d', 'e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
//        List<Character> upperCase = Arrays.asList('A','B','C','D', 'E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
//
//        Map<Character, Integer> smallCaseMap = new LinkedHashMap<>();
//        Map<Character, Integer> upperCaseMap = new LinkedHashMap<>();
//
//        // Happy case:
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (Character.isLowerCase(c)) {
//                smallCaseMap.put(c, smallCaseMap.getOrDefault(c, 0)+1);
//            } else {
//                upperCaseMap.put(c, upperCaseMap.getOrDefault(c, 0)+1);
//            }
//        }
//
//        Map<Character, List<Integer>> charIndexMap = new HashMap<>();
//
//        if(upperCaseMap.size() == smallCaseMap.size()) {
//            return upperCaseMap.size() + smallCaseMap.size();
//        } else {
//            for (int i = 0; i < str.length(); i++) {
//                char c = str.charAt(i);
//                if (!charIndexMap.containsKey(c)) {
//                    charIndexMap.put(c, new ArrayList<>());
//                }
//                charIndexMap.get(c).add(i);
//            }
//
//            for(Map.Entry<Character, List<Integer>> entry : charIndexMap.entrySet()) {
//                char ch = entry.getKey();
//                List<Integer> index = entry.getValue();
//
//
//            }
//        }
//
//        // "azABaabza";
//
//        System.out.println("charIndexMap :: " +charIndexMap);
//        System.out.println("charIndexMap :: " +charIndexMap.get('a'));
//        System.out.println("charIndexMap :: " +charIndexMap.get('A'));
//
//        return 0;
//    }



