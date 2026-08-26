package dsa.vvip;

// Given an array of strings strs, group the anagrams together.
// You can return the answer in any order.

// Example 1::
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

// Example 2::
// Input: strs = ["a"]
// Output: [["a"]]

// // Example 3::
// Input: strs = [""]
//Output: [[""]]

// strs[i] consists of lowercase English letters.

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> result = groupAnagrams(arr);
        System.out.println("result here:: " +result);

        System.out.println(groupAnagramsJava8(arr));
    }

    // Time Complexity : O(N * NlogN)
    private static List<List<String>> groupAnagrams(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : arr) {
            // Convert the string to a character array, sort it, and convert back to a string
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // System.out.println("sorted ::" + sorted);

            // If the sorted string is not in the map, add it
            if(!map.containsKey(sorted)) {
                map.put(sorted, new LinkedList<>());
            }
           // System.out.println("map ::" + map);

            // Add the current string to the corresponding anagram group
            map.get(sorted).add(str);
            //System.out.println("map here ::" +map);
        }

        return new LinkedList<>(map.values());
    }

    private static List<List<String>> groupAnagramsJava8(String[] arr) {
        return new ArrayList<>(Arrays.stream(arr)
                .collect(Collectors.groupingBy(str -> {
                    // Sort each string and use the sorted string as the key
                    char[] chars = str.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }))
                .values());
    }
}
