package interview_ques;

public class MissingNumberInArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 3, 7, 8};
        System.out.println(findMissingNumber(nums));
       // secondHighestElement(nums);

        String str = "123";
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());

        for (int i = str.length()-1; i >=0; i--) {
            System.out.print(str.charAt(i));
        }
    }


    public static int findMissingNumber(int[] nums) {
        // Calculate the expected sum of all numbers from 1 to n
        int n = nums.length + 1; // Expected size of the array (including the missing number)
        int expectedSum = (n * (n + 1)) / 2;

        // Calculate the actual sum of the given array
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // The difference between the expected sum and the actual sum is the missing number
        return expectedSum - actualSum;
    }
}
