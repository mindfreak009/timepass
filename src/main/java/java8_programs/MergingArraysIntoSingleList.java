package java8_programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Given an String[][]{{"a", "b"},{"c", "d"}, {"e", "f"}, {"g", "h"}}
//  return output as [a, b, c, d, e, f, g, h]

public class MergingArraysIntoSingleList {
    public static void main(String[] args) {
        String[][] dataArray = new String[][]{{"a", "b"},
                {"c", "d"}, {"e", "f"}, {"g", "h"}, {"c", "d"}};
        System.out.println(mergeElementsIntoSingleListAndRemoveDuplicates(dataArray));
        System.out.println(mergeElementsIntoSingleListAndRemoveDuplicates1(dataArray));
    }

    public static List<String> mergeElementsIntoSingleListAndRemoveDuplicates(String[][] dataArray) {
        return  Arrays.stream(dataArray)
                .flatMap(x -> Arrays.stream(x))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> mergeElementsIntoSingleListAndRemoveDuplicates1(String[][] dataArray) {
        List<String> seen = new ArrayList<>();

        return  Arrays.stream(dataArray)
                .flatMap(x -> Arrays.stream(x))
                .filter(s ->  {
                    if(!seen.contains(s)) {
                        seen.add(s);
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }
}
