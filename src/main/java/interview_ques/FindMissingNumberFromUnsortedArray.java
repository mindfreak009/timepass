package interview_ques;

// Time Compelxity : O(N)
// Space Compexity : O(1)

public class FindMissingNumberFromUnsortedArray {
    public static void main(String[] args) {

        int[] arr = {3, 1, 6, 2, 5};
        int totalNum = arr.length + 1;
        int missingNumber = findMissingNumber(totalNum, arr);
        System.out.println(missingNumber);
    }

    private static int findMissingNumber(int n, int[] arr) {
        int sum = 0;
        int expectedSum = (n * (n + 1)) / 2;
        System.out.println(expectedSum);

        for (int i = 0; i < arr.length; i++) {
            // Calculate the sum
            sum+= arr[i];
        }
        return expectedSum - sum;
    }
}
