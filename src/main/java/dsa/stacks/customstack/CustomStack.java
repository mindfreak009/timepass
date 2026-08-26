package dsa.stacks.customstack;

import dsa.stacks.StackException;

// Time complexity : O(N)
public class CustomStack {

    protected int[] data;
    private static final int DEFAULT_SIZE=10;

    int pointer = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) {
        if(isFull()) {
            System.out.println("Stack is full");
        }
        pointer++;
        data[pointer] = item;
        return true;
    }

    public int pop() throws StackException {
        if(isEmpty()) {
            throw new StackException("Cannot pop from empty stack");
        }
//        int removed = data[pointer];
//        pointer --;
//        return removed;

        return data[pointer--];
    }

    public int peek() throws StackException {
        if(isEmpty()) {
            throw new StackException("Cannot pop from empty stack");
        }
        return data[pointer];
    }
    public boolean isFull() {
        return pointer == data.length -1;  // pointer is at last index
    }

    public boolean isEmpty() {
        return pointer == -1;
    }

    public static void main(String[] args) throws StackException {

        CustomStack stack = new CustomStack(5);
        stack.push(5);
        stack.push(15);
        stack.push(57);
        stack.push(45);
        stack.push(65);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());



    }
}
