package dsa.arrays;

import java.util.Stack;

public class MinumumDeletionToMakeStringBalanced {
    public static void main(String[] args) {

        //String str = "baababbba";
        String str = "baaababbbab";
        int i = minimumDeletionToMakeStringBalanced(str);
        System.out.println(i);

        int j =  minimumDeletionToMakeStringBalancedOptimized(str);
        System.out.println(j);

        int k =  minimumDeletionsUsingStack(str);
        System.out.println(k);
    }

    private static int minimumDeletionToMakeStringBalanced(String str) {
        int n = str.length();
        int[] aCount = new int[n];
        int[] bCount = new int[n];

        // bCount - left to right
        for (int i = 1; i<n; i++) {
            char prevCh = str.charAt(i-1);
            bCount[i] = bCount[i-1];
            if(prevCh == 'b') {
                bCount[i] += 1;
            }
        }

        // aCount - right to left
        for (int i = n-2; i >= 0; i--) {
            char prevCh = str.charAt(i+1);
            aCount[i] = aCount[i+1];
            if(prevCh == 'a') {
                aCount[i] += 1;
            }
        }

        int minDeletion = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minDeletion = Math.min(minDeletion, aCount[i]+bCount[i]);
        }
        return minDeletion;
    }

    private static int minimumDeletionToMakeStringBalancedOptimized(String str) {
        int n = str.length();
        int[] aCount = new int[n];

        // aCount - right to left
        for (int i = n-2; i >= 0; i--) {
            char prevCh = str.charAt(i+1);
            // System.out.println("here :: " + aCount[i]);
            aCount[i] = aCount[i+1];
            if(prevCh == 'a') {
                aCount[i] += 1;
            }
        }

        int bCount = 0;
        int minDeletion = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minDeletion = Math.min(minDeletion, aCount[i] + bCount);
            if(str.charAt(i) == 'b') {
                bCount += 1;
            }
        }
        return minDeletion;
    }

    public static int minimumDeletionsUsingStack(String str) {
        int count=0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!st.isEmpty() && st.peek()=='b' && ch=='a'){
                count++;
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        return count;
    }
}
