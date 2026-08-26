package dsa.greedy_algorithm;

// You are given an integer num.
// You can swap two digits at most once to get the maximum valued number.
// Return the maximum valued number you can get.

//  Constraints:   0 <= num <= 108

// Example 1:
// Input: num = 2736
// Output: 7236
// Explanation: Swap the number 2 and the number 7.

// Example 2:
// Input: num = 9973
// Output: 9973
// Explanation: No swap.

// Time Complexity : O(N)
public class MaximumSwap {
    public static void main(String[] args) {
        // int num = 2736;
        int num = 347153;
        // int num = 9973;
        int i = maximumSwap(num);
        System.out.println("maximum Number :: " + i);
    }

    public static int maximumSwap(int num) {
        // converting the number to character    array
        char[] numArr = Integer.toString(num).toCharArray();
        int n = numArr.length;

        char maxElement = numArr[n-1];
        int maxIndex = n-1;
        int swapIdx1 = -1;
        int swapIdx2 = -1;

        for (int i = n-2; i >= 0; i--) {
            if(numArr[i] > maxElement) {
                maxElement = numArr[i];
                maxIndex = i;
            } else if (numArr[i] < maxElement) {
                swapIdx1 = i;          // 3
                swapIdx2 = maxIndex;   // 4
            }
        }
            if(swapIdx1 != -1) {
                char temp = numArr[swapIdx1];
                numArr[swapIdx1] = numArr[swapIdx2];
                numArr[swapIdx2] = temp;
            }
        // converting char[] {{array}}  back to Integer and returning
        return Integer.parseInt(new String(numArr));
    }
}
