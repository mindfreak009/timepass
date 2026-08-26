package java_oca;

import java.util.Arrays;

// Output:  AB


public class Ques154 {
    public static void main(String[] args) {
        String[] strs = {"A", "B"};
        int idx = 0;
        for(String s: strs) {
            strs[idx].concat(" element " +idx);
            idx++;
        }

        System.out.println(Arrays.toString(strs));

        for (idx = 0; idx < strs.length; idx++) {
            System.out.print(strs[idx]);
        }
    }
}
