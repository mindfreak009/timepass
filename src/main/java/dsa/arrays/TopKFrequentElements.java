package dsa.arrays;

// Given an integer array nums and an integer k, return the k most frequent elements.
// You may return the answer in any order.

// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

// Example 2:
// Input: nums = [1], k = 1
// Output: [1]

import java.util.*;


class Pair implements Comparable<Pair> {
   int data;
   int freq;

    public Pair(int data, int freq) {
        this.data = data;
        this.freq = freq;
    }


    @Override
    public int compareTo(Pair p) {
        int answer = 0;
        // If frequencies are different, compare them (max heap, higher frequency comes first)
        if (this.freq != p.freq) {
            return p.freq - this.freq;  // Max heap: higher frequency should come first
        }
        // If frequencies are the same, compare by data value (max heap: larger data comes first)

        return p.data - this.data; // Larger data value comes first if frequencies are equal

    }

    @Override
    public String toString() {
        return "Pair{" +
                "data=" + data +
                ", freq=" + freq +
                '}';
    }

}


public class TopKFrequentElements {
    public static void main(String[] args) {
        // int[] nums = {1,1,1,2,2,3};
        int[] nums = {3, 1, 4, 4, 5, 2, 6, 1};  // output: 4 1
        int k = 2;
        int[] result = topKFrequent(nums, 2);
        System.out.println("final result :: " + Arrays.toString(result));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        System.out.println(map);

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();

        // insert elements in priority queue
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            priorityQueue.offer(pair);
            // add() method also works same as offer() method
           //  priorityQueue.add(pair);
        }
        System.out.println("priority queue ::" +priorityQueue);

        int[] result = new int[k];
        int index = 0;
        while(index < k) {
            Pair p = priorityQueue.poll();
            result[index] = p.data;
            index++;
        }

        return result;
    }
}
