package dsa.queue;

import java.util.LinkedList;
import java.util.Queue;

// Note : Consider only even digit numbers
// if k=5 then 11 22 1111 1221 2222
public class Generate_Kth_Palindrome_Num_In_Series_Using_1_And_2_Only {
    public static void main(String[] args) {

        int k = 5;
        String number = generateKth_Palindrome_Number_Series(k);
        System.out.println("number ::: " + number);

    }

    private static String generateKth_Palindrome_Number_Series(int k) {
        Queue<String> queue = new LinkedList<>();
        queue.add("11");
        queue.add("22");

        String ans = "";
        for (int i = 1; i <=k; i++) {
            ans = queue.remove();

            // finding the left and right of numbers
            String left = ans.substring(0, ans.length()/2);
            String right = ans.substring(ans.length()/2);

            queue.add(left + "11" + right);
            queue.add(left + "22" + right);
        }
        return queue.toString();
    }
}
