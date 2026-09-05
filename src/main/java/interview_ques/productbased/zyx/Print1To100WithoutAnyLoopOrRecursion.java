package interview_ques.productbased.zyx;

import java.util.Arrays;
import java.util.BitSet;

public class Print1To100WithoutAnyLoopOrRecursion {
    public static void main(String[] args) {

        //1. Using Arrays.fill() method
        Object num[] = new Object[100];
        Arrays.fill(num, new Object() {
            int count = 0;
            @Override
            public String toString() {
                return Integer.toString(++count);
            }
        });
        System.out.println(Arrays.toString(num));
        System.out.println("=====================================================");

        //2. BitSet
        String set = new BitSet() {{set(1,101);}}.toString();
        System.out.append(set, 1, set.length());
    }
}
