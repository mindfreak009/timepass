package shashcode30;

// Difficulty : Medium

// There is a school that has classes of students and each class will be having a final exam.
// You are given a 2D integer array classes, where classes[i] = [passi, totali].
// You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.

// You are also given an integer extraStudents. There are another extraStudents brilliant
// students that are guaranteed to pass the exam of any class they are assigned to.
// You want to assign each of the extraStudents students to a class in a way that maximizes
// the average pass ratio across all the classes.

// The pass ratio of a class is equal to the number of students of the class that will pass
// the exam divided by the total number of students of the class. The average pass ratio is
// the sum of pass ratios of all the classes divided by the number of the classes.

// Return the maximum possible average pass ratio after assigning the extraStudents students.
// Answers within 10-5 of the actual answer will be accepted.

// Example 1:
// Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
// Output: 0.78333
// Explanation: You can assign the two extra students to the first class.
// The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.

// Example 2:
// Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
// Output: 0.53485

import java.util.PriorityQueue;

public class MaximumAveragePassRatio_1792 {
    public static void main(String[] args) {
       int[][] classes = {{1,2},{3,5},{2,2}};
       int extraStudents = 2;
        System.out.println(maxAverageRatio(classes, extraStudents));
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        // diff, pass, total
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));

        // insert in priority queue (sorted as diff, high to low)
        for(int[] arr : classes) {
             int pass = arr[0];
             int total = arr[1];
             double diff = findDiff(pass, total);
             pq.offer(new double[] {diff, pass, total});
        }

        // include extraStudents in that class which will have the highest pass ratio
        while(extraStudents > 0) {
            double arr[] = pq.poll();
            int pass = (int) arr[1] + 1;
            int total = (int) arr[2] + 1;
            double diff = findDiff(pass, total);
            pq.offer(new double[] {diff, pass, total});
            extraStudents--;
        }

        // sum of pass ratio
        double totalPassRatio = 0;
        while(!pq.isEmpty()) {
            double arr[] = pq.poll();
            double pass = arr[1];
            double total = arr[2];
            totalPassRatio +=  (pass / total);
        }
        //average of pass ratio
        return totalPassRatio / classes.length;
    }

    public static  double  findDiff(int pass, int total) {
        return ( (double) (pass+1) / (total+1) ) - ((double) pass / total);
    }
}
