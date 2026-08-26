package dsa.dynamicprogramming;

// Greedy algorithm
// Time complexity: O(N)

public class FindMinimumJump {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        // int[] arr = {2,4,1,2,3,1,1,2};

        int minJumps = findMinJumps(arr);
        System.out.println("Minimum Jumps :: " +minJumps);

    }

    private static int findMinJumps(int[] nums) {
        int totalJumps = 0;

        // destination is last index
        int dest = nums.length - 1;

        int coverage = 0, lastJumpIdx = 0;

        // Base case
        if (nums.length == 1)
            return 0;

        // Greedy strategy: extend coverage as long as possible
        for (int i = 0; i < nums.length; i++) {
            coverage = Math.max(coverage, i + nums[i]);

            if (i == lastJumpIdx) {
                lastJumpIdx = coverage;
                totalJumps++;

                // check if we have reached destination already
                if (coverage >= dest) {
                    return totalJumps;
                }
            }
        }

        return totalJumps;
    }
}
