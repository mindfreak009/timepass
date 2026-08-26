package interview_ques.mphasis;

import java.util.ArrayList;
import java.util.List;

// output: 4,5,6,7,8,1,2,3
public class RotateNumberByGivenArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8, 9, 10};
        int numOfRotation = 6;
        System.out.println(rotateNumber(arr, numOfRotation));
    }

    // Time Complexity: O(N)
    private static List<Integer> rotateNumber(int[] arr, int numOfRotation) {
        List<Integer> list = new ArrayList<>();
        int j = numOfRotation;

        for (int i = 0; i < numOfRotation; i++) {
              while(j< arr.length) {
                  list.add(arr[j]);
                  j++;
              }
            list.add(arr[i]);
        }
        return list;
    }
}
