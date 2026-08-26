package interviewtime;

// Write a function:

// class Solution { public int solution(int[] A); }

// that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
// For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

// Given A = [1, 2, 3], the function should return 4.
// Given A = [−1, −3], the function should return 1.

// Write an efficient algorithm for the following assumptions:
// N is an integer within the range [1..100,000];
// each element of array A is an integer within the range [−1,000,000..1,000,000].

// Example test:   [1, 3, 6, 4, 1, 2]
// WRONG ANSWER (got 2 expected 5)

// Example test:   [1, 2, 3]
// WRONG ANSWER (got 2 expected 4)

import java.util.*;

// Example test:   [-1, -3]
//OK
public class TomTomCodilityTest {
    public static void main(String[] args) {
       // int[] test = {1, 3, 6, 4, 1, 2};  // Output: 5
       int[] test = {1, 2, 3};  // Output: 4
       // int[] test = {-1, -3};  // Output: 1
        System.out.println("final Answer :: " + solution(test));
    }


    public static int solution(int[] A) {
        // Implement your solution here

        // Edge case:
        if(A.length == 1 && A[0] < 0) {
                return 1;
        }

        int max = Arrays.stream(A).max().getAsInt();
        int min =  Arrays.stream(A).min().getAsInt();

        Set<Integer> set = new HashSet<>();
        for (int i = min; i <= max; i++) {
            set.add(i);
        }

        if(max < 0) {
            return 1;
        } else {
            for (int ar : A) {
                set.remove(ar);
            }
        }

        if(!set.isEmpty())
            return Collections.min(set);
        else {
            return max+1;
        }
    }
}
