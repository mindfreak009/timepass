package interview_ques.productbased.zyx;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
       // int[] arr = { 13 , 7, 6 , 12 };
        int[] arr = { 17 , 5, 13 , 8, 16, 1, 2 };

       // findNextGreaterElement(arr);
        int[] nextGreaterElementUsingStack = findNextGreaterElementUsingStack(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "  Next Greater Element      ---> " +nextGreaterElementUsingStack[i]);
        }
    }

    // Time complexity - O(n*n)
    static int[] findNextGreaterElement(int[] arr) {
        int nextGreaterElem = 0;
        for (int i = 0; i < arr.length; i++) {
            nextGreaterElem = -1;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    nextGreaterElem =  arr[j];
                    break;
                }
            }
            System.out.println("Next Greater Element " +arr[i] + " ---> " +nextGreaterElem);
        }
        return new int[]{nextGreaterElem};
    }

    // Time Complexity - O(n)
    // Space Complexity - O(n) === since we are using extra space (Stack)
    static int[] findNextGreaterElementUsingStack(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1); // Initialize result array with -1
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i];
               // System.out.println("result inside :: " + Arrays.toString(result));
            }
            stack.push(i);
        }
        //System.out.println(Arrays.toString(result));
        return result;
    }
}
