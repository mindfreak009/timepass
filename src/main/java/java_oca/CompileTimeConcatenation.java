package java_oca;

// When you do (String + String) Compile-Time Concatenation, it will return TRUE, in case of Memory Location comparison

// Output: true

public class CompileTimeConcatenation {
    public static void main(String[] args) {
        String a = "abcd";
        String b = "abcd123";
        String c = "abcd" + 123;
        System.out.println(b == c);  // true
    }
}
