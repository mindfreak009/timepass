package java_oca;

// Output:   A NullPointerException is thrown at runtime.

//          (Cannot invoke "String.concat(String)" because "strs[idx]" is null)
//  •	Element 0 Element 1
//  •	Null element 0 Null element 1
//  •	Null Null

public class Ques52 {
    public static void main(String[] args) {
        String[] strs = new String[2];
        int idx = 0;
        for (String s : strs) {
            strs[idx].concat(" element " +idx);
        }
        for (idx = 0; idx < strs.length; idx++) {
            System.out.println(strs[idx]);
        }
    }
}
