package interview_ques.bnpparibas;


import java.util.ArrayList;
import java.util.List;

public class TopKElementsUsingPriorityQueue {

    // static inner class to hold value and its frequency
    static class Pair {
        int val;
        int freq;

        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    ", freq=" + freq +
                    '}';
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int nums = 3;

        int[] x = {2, 3, 10, 11, 7};
        int[] y = {4, 7, 27, 27, 26};

        process(n, nums, x, y);
    }

    public static void process (int n, int nums, int[] x, int[] y) {
        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new Pair(x[i], y[i]));
        }

        list.sort((a, b) -> {
            if(a.freq != b.freq)
                return b.freq - a.freq;  // higher frequency first
            return b.val - a.val;        // higher value first if frequencies tie;
        });

        System.out.println("List becomes:: " + list);

        for (int i = 0; i < nums ; i++) {
            System.out.print(list.get(i).val + " ");
        }
    }
}
