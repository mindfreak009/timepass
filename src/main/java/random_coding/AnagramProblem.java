package random_coding;

import java.util.Arrays;

public class AnagramProblem {
    public static void main(String[] args) {

        AnagramProblem a = new AnagramProblem();
        System.out.println(a.checkAnagram("restful".toCharArray(), "fluster".toCharArray()));
    }

    // Time complexity : O(N logN) since we are using Arrays.sort() method
    // Space complexity : O(N) since we are usng character array to store the elements.
    private boolean checkAnagram(char[] char1, char[] char2) {
        if(char1.length != char2.length) {return false; };

        // sort the letters of the strings
        // O(N logN) this is the "bottleneck" of the algorithm
        Arrays.sort(char1);
        Arrays.sort(char2);

        System.out.println("char1 ::: "+Arrays.toString(char1));
        System.out.println("char2 ::: "+Arrays.toString(char2));

        // consider all the letters one by one and we have compare those letters
        // O(N) but the overall running time is O(NlogN) + O(N) = O(NlogN)
        for (int i= 0; i<char1.length; ++i) {
            if(char1[i] != char2[i]) {
                return false;
            };
        }
        return true;
    }
}
