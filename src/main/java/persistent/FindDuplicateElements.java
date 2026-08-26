package persistent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// Output: 15, 98

// time complexity: O(N)
// space complexity: O(N)
public class FindDuplicateElements {
    public static void main(String[] args) {
       List<Integer> list =  Arrays.asList(10,15,8,49,25,98,98,32,15);
        System.out.println(findDuplicateElements(list));
    }

    private static List<Integer> findDuplicateElements(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        List<Integer> collect = list.stream()
                .filter(e -> !set.add(e))
                .collect(Collectors.toList());

        return collect;
    }
}
