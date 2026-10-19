package interview_ques.servicebased.sonatasoftware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//      1  2  3  4  5  6  7  8  9  10  11  12
//      -------
//         -------------
//                           --------
//                              -------------

// Expected Output:
//          [[1, 6], [8, 12]]

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {9, 12}
        };

        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <=1) {
            return intervals;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int next[] = intervals[i];

            if(next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap: save the current interval
                result.add(current);
                current = next;
            }

            //  ●  next[0] gets the start of the next interval
            //  ●  current[1] gets the end of the current interval
            //  ●  next[1] gets the end of the next interval.

//            Step-by-step example
//               ●  For current = [1,3] and next = [2,6]:
//
//               ●  Check 2 <= 3 — true, so the intervals overlap.
//               ●  Calculate Math.max(3, 6) — the result is 6.
//               ●  Update current[1] = 6.

        }

        // Add the final interval
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}
