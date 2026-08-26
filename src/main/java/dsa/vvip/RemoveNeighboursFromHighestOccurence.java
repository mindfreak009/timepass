package dsa.vvip;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveNeighboursFromHighestOccurence {

    public static List<Integer> removeNeighborsOfMostFrequent(List<Integer> input) {
        // count frequencies
        Map<Integer, Integer> countFreq = new HashMap<>();
        for (int num: input) {
            countFreq.put(num, countFreq.getOrDefault(num, 0)+1);
        }

        // Find the most frequent element
        int mostFrequent = input.get(0);
        int maxCount = 0;

        for(Map.Entry<Integer, Integer> entry: countFreq.entrySet()) {
            if(entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        System.out.println("mostFrequent: " +mostFrequent);
        System.out.println("maxCount: " +maxCount);
        // Mark neighbors for removal
        boolean[] remove = new boolean[input.size()];
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == mostFrequent) {
                if (i > 0) {
                    remove[i - 1] = true;
                }
                if (i < input.size() - 1) {
                    remove[i + 1] = true;
                }
            }
        }

        // Build result
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (!remove[i]) {
                result.add(input.get(i));
            }
        }
        return result;
    }

    // Time Complexity: O(N)
    public static List<Integer> removeNeighborsOfMostFrequentElements(List<Integer> input) {
        // list to store the final results
        List<Integer> result = new ArrayList<>();

        // Find the frequent elements
        // Time Complexity: O(N)
        int maxNum = input.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue()>1)
                .map(Map.Entry::getKey)
                .max(Integer::compareTo)
                .orElse(-1);

        System.out.println("maxRepeatingNumbers :: " + maxNum);
        // Time Complexity: O(N)
        for(int i=0; i<input.size(); i++) {
            boolean leftNeighbor =  i>0 && input.get(i-1)==maxNum;
            boolean rightNeighbor = i<input.size()-1 && input.get(i+1)==maxNum;

           if(!leftNeighbor && !rightNeighbor) {
               result.add(input.get(i));
           }
        }
        return result;
    }


    public static List<Integer> removeNeighbors(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        List<Integer> list = new ArrayList<>();

        boolean[] remove = new boolean[arr.length];
        for (int i=0; i<arr.length; i++) {
            if(arr[i] == max) {
                // For left neighbour
                if(i > 0) {
                    remove[i-1] = true;
                }
                // For right neighbour
                if(i < arr.length-1) {
                    remove[i+1] = true;
                }
            }
        }

        System.out.println("arr.length:: " + arr.length);
        System.out.println(Arrays.toString(remove));
        System.out.println();
        for(int i=0; i<arr.length; i++) {
            if(!remove[i]) {
                list.add(arr[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 10, 11, 3, 7, 10, 15, 2};
        System.out.println("first one:: " + removeNeighbors(arr));

        List<Integer> input =
                Arrays.asList(5, 1, 10, 11, 3, 7, 10, 15, 2);
        List<Integer> output = removeNeighborsOfMostFrequent(input);
        List<Integer> output1 = removeNeighborsOfMostFrequentElements(input);
        System.out.println(output);
        System.out.println("from family 1::: " + output1);

    }
}
