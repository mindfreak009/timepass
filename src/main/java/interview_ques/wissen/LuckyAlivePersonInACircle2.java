package interview_ques.wissen;

//  last remaining person in the circle
// int[] arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
// 1, 3, 5, 7 , 9
// 1, 5, 9
// 5, 9
// 5

import java.util.ArrayList;
import java.util.List;

//    int[] arr = [1, 2, 3, 4, 5]
// 1. Targets = [1,2,3,4,5], Targets to be removed are [1,3,5]
//    Points  = 0+1+3+5=9
// 2. Targets = [2,4]. Targets to be removed are [2]
//    Points =  9+2=11
// 3. Targets = [4].  ONLY one target is left, therefore return total points, i.e.. 11

public class LuckyAlivePersonInACircle2 {
    public static void main(String[] args) {
        // int[] arr = {1,2,3,4,5};
        int[] arr = {1,2,3,4,5,6,7,8,9}; // 1 3 5 7 9 // 2 6 // 4
        System.out.println(findTotalPoints(arr));
    }

    private static int findTotalPoints(int[] arr) {

        List<Integer> result = new ArrayList<>();
        int originalSize = arr.length;

        for (int i = 0; i < arr.length ; i++) {
            result.add(arr[i]);
        }

        int totalPoints = 0;
        // Here, we have taken -1 because we want to start with 0th index.
        int i = -1;
        while(result.size() > 1) {
            if(result.size() == 2) {
                i = (i) % originalSize;
                totalPoints += result.remove(i);
                System.out.println("totalPoints here :: " +totalPoints);
                return totalPoints;
            }
            i = (i+1) % originalSize;
            System.out.println("i :: " + i);
            totalPoints += result.remove(i);
            System.out.println("totalPoints :: " +totalPoints);
            originalSize--;
        }

        return totalPoints;
    }
}
