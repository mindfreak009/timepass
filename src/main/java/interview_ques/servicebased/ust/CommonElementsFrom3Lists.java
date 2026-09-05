package interview_ques.servicebased.ust;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Find common elements from 3 lists
public class CommonElementsFrom3Lists {
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
        List<Integer> list3 = Arrays.asList(0, 3, 4, 7);

        System.out.println(findCommonElementsFrom3Lists(list1, list2, list3));
        System.out.println(findCommonElementsFrom3ListsUsingStreams(list1, list2, list3));

    }

    // Best optimized approach
    // Time Complexity:
    //     • Creating sets:  O(n + m + k)
    //     • retainAll():    Average O(smaller set size)

    public static Set<Integer> findCommonElementsFrom3Lists(List list1, List list2, List list3) {
        // Step 1: Convert all lists to HashSet first:
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        Set<Integer> set3 = new HashSet<>(list3);

        // Step 2:
        set1.retainAll(set2);
        set1.retainAll(set3);

        return set1;
    }

    // Worst time complexity
    // Time Complexity:
    //   • List.contains() is:  O(n)
    //   • So, overall time complexity becomes O(n * m * k)
    public static List<Integer> findCommonElementsFrom3ListsUsingStreams(List list1, List list2, List list3) {

        return list1.stream()
                .filter(list2::contains)
                .filter(list3::contains)
                .distinct()
                .toList();
    }


}