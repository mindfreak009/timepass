package java_oca;

public class Ques4 {
    public static void main(String[] args) {
        Short s1 = 200;
        Integer s2 = 400;
        Long s3 = (long) s1 + s2;
        // String str = (String) (s3 * s2);   // Compilations fails at this line.
        String ss = String.valueOf(s3 * s2);
        System.out.println("Sum is :: " +ss);
    }
}
