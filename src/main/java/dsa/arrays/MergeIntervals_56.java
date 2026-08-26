package dsa.arrays;

// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
// and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

// Example 2:
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.

// Constraints:
//       1 <= intervals.length <= 104
//       intervals[i].length == 2
//       0 <= starti <= endi <= 104

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals_56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        // to print 2D string ---> Arrays.deepToString()
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

//        for (int[] a : intervals) {
//            System.out.println(Arrays.toString(a));
//        }
        ArrayList<int[]> arraysList = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i : intervals) {
            if(end >= i[0]) {
                end = Math.max(end, i[1]);
            } else {
                arraysList.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        arraysList.add(new int[]{start, end});
        return arraysList.toArray(new int[arraysList.size()][]);
    }
}
