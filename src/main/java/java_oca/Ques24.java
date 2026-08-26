package java_oca;

// What is the result ?
public class Ques24 {
    public static void main(String[] args) {
        Short s1 = 200;
        Integer s2 = 400;

        // Ans:  Compilation will fail at line n1

       //  String s3 = (String) (s1 + s2); // line n1
        Long s4 = (long) s1 + s2;       // line n4
        System.out.println("Sum is :: " +s4);
    }
}
