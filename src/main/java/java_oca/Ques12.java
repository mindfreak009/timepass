package java_oca;

public class Ques12 {
    public static void main(String[] args) {
        String ta = "A";
        ta = ta.concat("B ");    // A B
        String tb = "C";
        ta = ta.concat(tb);          // A B C
        ta.replace('C', 'D');  // A B D
        ta = ta.concat(tb);                    // A B C C
        System.out.println(ta);               // A B C C
    }
}
