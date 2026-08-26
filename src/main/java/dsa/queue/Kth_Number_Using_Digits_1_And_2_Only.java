package dsa.queue;


// if k=5, then 1 2 11 12 21
// if k=7  then 1 2 11 12 21 22 111

import java.util.LinkedList;
import java.util.Queue;

public class Kth_Number_Using_Digits_1_And_2_Only {
    public static void main(String[] args) {

        int k = 5;
        String number = generateKth_Number(k);
        System.out.println("Number is :: " + number);

    }

    private static String generateKth_Number(int k) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");

        String ans = "";
        for (int i = 1; i <=k; i++) {
            ans = queue.remove();
            queue.add(ans + "1");
            queue.add(ans + "2");
        }
        return ans;
    }
}
