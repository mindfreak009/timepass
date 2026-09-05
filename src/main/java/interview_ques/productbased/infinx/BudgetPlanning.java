package interview_ques.productbased.infinx;

import java.util.*;

public class BudgetPlanning {

    // Function to solve the problem
    public static int solve(int N, int[] arr) {

        if(arr.length <= 1) {
            return 1;
        }

        // Create a set to track the containers (values that we can use)
        Set<Integer> containers = new HashSet<>();

        // Add the first value from the array as an initial container
        containers.add(arr[0]);

        // For each subsequent arr[i], check if we can derive it from existing containers
        for (int i = 1; i < N; i++) {
            boolean found = false;

            // Try to find a valid operation to generate arr[i] from existing containers
            for (int container : containers) {
                // Check if arr[i] can be created by adding a multiple of container
                if ((arr[i] - container) % container == 0) {
                    containers.add(arr[i]);  // Add the new container value
                    found = true;
                    break;
                }
            }

            // If no valid operation found, return -1
            if (!found) {
                return -1;
            }
        }

        // The number of containers used is the size of the set
        return containers.size();
    }

    public static void main(String[] args) {

//        int[] arr = {33456};
//        int N = 1;

//        int[] arr = {3, 6, 2};
//        int N = 3;

//        int[] arr = {2, 4, 8};
//        int N = 3;

        int[] arr = {11, 22, 44, 88, 121, 65, 35, 25, 7};
        int N = 10;

        // Call the solve function and output the result
        int result = solve(N, arr);
        System.out.println(result);

    }
}

