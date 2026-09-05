package interview_ques.productbased.pwc;

import java.util.*;

// O/P-> [["tan", "nat"], ["eat", "tea"]]
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str =  {"eat", "tan", "nat", "tea"};
        System.out.println(createGroupAnagram(str));
    }

    // Time complexity: O(N * NlogN)
    private static List<List<String>> createGroupAnagram(String[] arr) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : arr) {
            // Converting string to character array
          char[] chars = str.toCharArray();
          Arrays.sort(chars);                       // O(N logN)
          // converting char array back to String
          String st = new String(chars);

          // If the sorted string is not in map, add it
          if(!map.containsKey(st)) {
              map.put(st, new ArrayList<>());
          }
          // Now, add the current string to the corresponding anagram group
            map.get(st).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
