package interview_ques.servicebased.calsoft;

// Use collection framework. Remove duplicate and order in ascending.

//int A [] = {1,2,3,3,2,1}

import java.util.*;

// 123
public class RemoveDuplicatesAndArrangeInAscOrder {
    public static void main(String[] args) {
        int[] a = {1,2,3,3,2,1, 7,8,9,10,11, 4, 5,6, 1,2,3,3,2,1, 7,8,9,10,11, 4, 5,6};
        System.out.println(removeDuplicates(a));

    }

    public static List<Integer> removeDuplicates(int[] a) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            if(!set.contains(a[i])) {
                set.add(a[i]);
            }
        }
        // return set;
        // copyOf() function is available from Java 10
        return List.copyOf(set);
    }
}
