package dsa.priorityqueue;

// Given an integer array nums and an integer k, return the k most frequent elements.
//  You may return the answer in any order.

// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

// Example 2:
// Input: nums = [1], k = 1
// Output: [1]

// Constraints:
//  1 <= nums.length <= 105
//  -104 <= nums[i] <= 104
//  k is in the range [1, the number of unique elements in the array].
//  It is guaranteed that the answer is unique.

import java.util.*;

class Pair implements Comparable<Pair> {
    int element, frequency;
    Pair(int element, int frequency) {
        this.element = element;
        this.frequency = frequency;
    }
    @Override
    public int compareTo(Pair p) {
        // maxHeap
        return  p.frequency - this.frequency; // decreasing
    }

    @Override
    public String toString() {
        return "Pair{" +
                "element=" + element +
                ", frequency=" + frequency +
                '}';
    }
}

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,8};
        int k = 2;
        int[] result = topKFrequentElements(nums, k);
        System.out.println("result is ::" + Arrays.toString(result));
    }

    private static int[] topKFrequentElements(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int arr : nums )
            map.put(arr, map.getOrDefault(arr, 0)+1);

        PriorityQueue<Pair> priorityQueue = new PriorityQueue();

        // insert elements in priority queue
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            priorityQueue.offer(pair);
        }
        System.out.println("priorityQueue :: " + priorityQueue);
//        for (int key : keys) {
//            if(priorityQueue.size() < k)
//                priorityQueue.add(new Pair(key, map.get(key)));
//            else if(priorityQueue.peek().element < map.get(key)) {
//                priorityQueue.poll();
//                priorityQueue.add(new Pair(key, map.get(key)));
//            }
//        }

        int[] result = new int[k];
        int index = 0;
        while (index < k) {
            Pair pair = priorityQueue.poll();
            result[index] = pair.element;
            index++;
        }
        return result;
    }
}


