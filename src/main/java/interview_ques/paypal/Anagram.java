package interview_ques.paypal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

// find two string is anagram or not anagrams
public class Anagram {
    public static void main(String[] args) {
        String s1 = "letter";
        String s2 = "rttele";

        String result = findAnagramUsingHashMap(s1, s2);
        System.out.println(result);
    }

private static String findAnagramUsingHashMap(String s1, String s2) {
    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();

    if(s1.length() != s2.length()) {
        return "Length of string doesn't match";
    }

    for (int i = 0; i < s1.length(); i++) {
        char c1 = s1.charAt(i);
//        if (!map1.containsKey(c1)) {
//            map1.put(c1, 1);
//        } else {
//            map1.put(c1, (map1.get(c1) + 1));
//        }

         map1.put(c1, map1.getOrDefault(c1, 0)+1);
    }

    for (int j = 0; j < s2.length(); j++) {
        char c2 = s2.charAt(j);
//        if (!map2.containsKey(c2)) {
//            map2.put(c2, 1);
//        } else {
//            map2.put(c2, (map2.get(c2) + 1));
//        }

        map2.put(c2, map2.getOrDefault(c2, 0) + 1);    }

    System.out.println("map1 :: " + map1);
    System.out.println("map2 :: " + map2);

    if(map1.equals(map2)) {
        return "String is anagram";
    } else {
        return "String is not anagram";
    }

//    if(Objects.equals(map1, map2)) {
//        return "String is anagram";
//    } else return "String is not anagram";

}



    private static boolean findAnagramUsingStack(String str1, String str2) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        if(str1.length() != str2.length()) {
            return false;
        }

        Arrays.sort(str1.toCharArray());
        Arrays.sort(str2.toCharArray());

        System.out.println("here  :: "  +str1);
        System.out.println("here 2 ::: " + str2);

        for (char c : str1.toCharArray()) {
            stack1.push(c);
        }

        for (char c : str2.toCharArray()) {
            stack2.push(c);
        }


        System.out.println(stack1);
        System.out.println(stack2);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if(stack1.pop() != stack2.pop()) {
                return false;

            }
        }

        return stack1.isEmpty() && stack2.isEmpty();
    }


    private static boolean findAnagarm(String s1, String s2) {
        if(s1.length() != s2.length()) {
            System.out.println("String doesn't match");
            return false;
        }

        // converting String to char array
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        for (int i = 0; i < c1.length; i++) {
            if(c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
