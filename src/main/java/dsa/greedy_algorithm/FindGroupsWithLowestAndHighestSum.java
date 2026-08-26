package dsa.greedy_algorithm;

import java.util.*;

public class FindGroupsWithLowestAndHighestSum {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(44);
        numbers.add(5);
        numbers.add(95);
        numbers.add(65);

        // Create a map to store the sum of each group
        Map<Integer, Integer> groupSums = new HashMap<>();

        // Iterate over the list of integers and add them to the map
        for (int number : numbers) {
            int groupSum = groupSums.getOrDefault(number, 0);
            System.out.println("groupSum ::: " +groupSum);
            groupSum += number;
            groupSums.put(number, groupSum);
            System.out.println("groupSum ::: " +groupSum);

        }

        System.out.println(groupSums);

        // Find the group with the lowest sum
        int lowestSum = Collections.min(groupSums.values());
        System.out.println("lowestSum :: " +lowestSum);

        // Find the group with the highest sum
        int highestSum = Collections.max(groupSums.values());
        System.out.println("highestSum :: " +highestSum);

        // Print the groups with the lowest and highest sum
        System.out.println("The group with the lowest sum is: " + lowestSum);
        System.out.println("The group with the highest sum is: " + highestSum);
    }
}
