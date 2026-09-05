package interview_ques.productbased.zyx;

// Time Compelxity : O(N)
// Space Compexity : O(1)

public class FindMissingNumberFromUnsortedArray {
    public static void main(String[] args) {

        int[] arr = {3, 1, 6, 2, 5};
        int totalNum = arr.length + 1;
        int missingNumber = findMissingNumber(totalNum, arr);
        System.out.println("Missing number »»  " + missingNumber);
    }

    private static int findMissingNumber(int n, int[] arr) {
        int sum = 0;
        int expectedSum = (n * (n + 1)) / 2;

        for (int i = 0; i < arr.length; i++) {
            // Calculate the sum
            sum+= arr[i];
        }
        return expectedSum - sum;
    }
}
