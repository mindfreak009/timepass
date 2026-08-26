package java_oca;

// javac Ques56.java
// java  Ques56 1 2 3

// Output:

public class Ques56 {
    public static void main(String[] args) {
        System.out.println("String main  " +args[0]);
    }
    public static void main(int[] args) {
        System.out.println("int main  " +args[0]);
    }
    public static void main(Object[] args) {
        System.out.println("Object main  " +args[0]);
    }
}
