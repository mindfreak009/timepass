package dsa.stacks;

import java.util.Stack;

public class DeleteMiddleElementOfStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=1; i<=6; i++) {
            stack.push(i);
        }

        System.out.println("Stack initially :: "+stack);
        int current = 0;
        int mid = stack.size()/2;
        delete(stack, current, mid);
    }

    public static void delete(Stack<Integer> stack, int current, int mid){

        // To delete the middle element, we need to remove the element at the middle index
        Stack<Integer> tempStack = new Stack<>();

        // base case
        if(stack.isEmpty()) return;

        // If we found the mid, directly pop the element
        if(current == mid) {
            stack.pop();
            return ;
        }

        int count = 0;

        // Pop elements from the original stack and push into the temp stack
        // until we reach the middle index
        while (count < mid) {
            tempStack.push(stack.pop());
            count++;
        }
        stack.pop();

        while(!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        System.out.println("tempStack :: " + tempStack);

    }
}
