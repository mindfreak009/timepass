package interview_ques.servicebased.synechron;

import java.util.*;

// Output:   Ans: [1,1,4,2,1,1,0,0]
public class FindDailyTemperatures {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(73,74,75,71,69,72,76,73);
        System.out.println(Arrays.toString(dailyTemperatures(list)));
    }

    public static int[] dailyTemperatures(List<Integer> temperatures) {
        int n = temperatures.size();
        int[] ans = new int[n];

        // Stores indices whose warmer day hasn't been found yet
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Current temperature is warmer than temperatures at these indices
            while (!stack.isEmpty()
                    && temperatures.get(i) > temperatures.get(stack.peek())) {

                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;

            }

            stack.push(i);
            System.out.println("stack :: " + stack);
        }

        return ans;
    }

}
