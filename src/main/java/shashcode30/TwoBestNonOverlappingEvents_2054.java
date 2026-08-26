package shashcode30;

// Difficulty level: Medium

// You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei].
// The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei.
// You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.
// Return this maximum sum.

// Note that the start time and end time is inclusive: that is, you cannot attend two events
// where one of them starts and the other ends at the same time.
// More specifically, if you attend an event with end time t, the next event must start at or after t + 1.

// Example 1:
// Input: events = [[1,3,2],[4,5,2],[2,4,3]]
// Output: 4
// Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.

// Example 2:
// Example 1 Diagram
// Input: events = [[1,3,2],[4,5,2],[1,5,5]]
// Output: 5
// Explanation: Choose event 2 for a sum of 5.

// Example 3:
// Input: events = [[1,5,3],[1,5,1],[6,6,5]]
// Output: 8
// Explanation: Choose events 0 and 2 for a sum of 3 + 5 = 8.

// Constraints:
// 2 <= events.length <= 10^5
// events[i].length == 3
// 1 <= startTimei <= endTimei <= 10^9
// 1 <= valuei <= 10^6

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TwoBestNonOverlappingEvents_2054 {

    public static void main(String[] args) {
        int[][] events = {{1,3,2},{4,5,2},{2,4,3}};
        System.out.println(maxTwoEvents(events));
    }

    public static int maxTwoEvents(int[][] events) {
        // Sort on end time
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // Sort on start time
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        Arrays.stream(events).forEach(Arrays::toString);

        int prevMax = 0;
        int result = 0;

        for (int[] event :  events) {
            while (!pq.isEmpty() && pq.peek()[1] < event[0]) {
                // find prevMax
                prevMax = Math.max(prevMax, pq.peek()[2]);
                pq.poll();
            }
            result = Math.max(result, prevMax+event[2]);
            pq.offer(event);
        }

        return result;
    }
}
