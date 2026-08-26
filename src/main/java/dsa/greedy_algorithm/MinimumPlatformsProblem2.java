package dsa.greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumPlatformsProblem2 {

    static class TrainSchedule {
        int arrivalTime;
        int departureTime;

        public TrainSchedule(int arrivalTime, int departureTime) {
            this.arrivalTime = arrivalTime;
            this.departureTime = departureTime;
        }

        @Override
        public String toString() {
            return "TrainSchedule{" +
                    "arrivalTime=" + arrivalTime +
                    ", departureTime=" + departureTime +
                    '}';
        }
    }
    static class SortByArrival implements Comparator<TrainSchedule> {

        @Override
        public int compare(TrainSchedule o1, TrainSchedule o2) {
            return o1.arrivalTime -o2.arrivalTime;
        }
    }
    private static int countPlatforms(int[] arr, int[] dep) {
        TrainSchedule[] trains = new TrainSchedule[arr.length];

        // Store the arrival and departure time
        for (int i = 0; i < arr.length; i++) {
            trains[i] = new TrainSchedule(arr[i], dep[i]);
        }

        // sort trains based on arrival time
        Arrays.sort(trains, new SortByArrival());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(trains[0].departureTime);
        System.out.println("prior :: " +priorityQueue);

        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            TrainSchedule curr = trains[i];
            // Check if arrival time of current train is less than or equals to departure time
            // of previous train
            if(curr.arrivalTime <= priorityQueue.peek())
                count++;
            else
                priorityQueue.poll();

            priorityQueue.add(curr.departureTime);
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        int result = countPlatforms(arr, dep);
        System.out.println("result ::: " +result);
    }
}
