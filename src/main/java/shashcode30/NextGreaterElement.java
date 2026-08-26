package shashcode30;

// E.g. Input: arr[] = [ 4 , 5 , 2 , 25 ]
// Output: 4   –> 5
// 5   –> 2
// 2   –> 25
// 25  –> -1

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
       int[] arr =  {4 , 5 , 2 , 25};
        System.out.println(nxtGreaterElement(arr));
    }

    public static StringBuilder nxtGreaterElement(int[] arr) {
        // Stack to store elements for which we need to find the next greater element
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        // Traverse the array from (END to START ) right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // Pop elements from stack that are smaller than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If the stack is empty, there is no greater element, so print -1
            if (stack.isEmpty()) {
                sb.append(arr[i]);
                sb.append(" --> -1");
                sb.append("\n");

               // System.out.println(arr[i] + " --> -1");
            } else {
                // The next greater element is the top of the stack
                sb.append(arr[i]);
                sb.append(" --> ");
                sb.append(stack.peek());
                sb.append("\n");
                // System.out.println(arr[i] + " --> " + stack.peek());
            }

            // Push the current element onto the stack
            stack.push(arr[i]);
        }
        return sb;
    }
//    private static String nxtGreaterElement(int[] arr) {
//        StringBuilder sb = new StringBuilder();
//
//        int notFound = -1;
//        for (int i = 1; i < arr.length-1; i++) {
//            int currElement = arr[i-1];
//            int nxtGreaterElem = arr[i];
//            if(nxtGreaterElem > currElement) {
//                sb.append(currElement);
//                sb.append(" ->  ");
//                sb.append(nxtGreaterElem);
//            } else if(arr[i] == arr[arr.length-1]){
//                sb.append(notFound);
//            }
//        }
//        return sb.toString();
//    }
}
