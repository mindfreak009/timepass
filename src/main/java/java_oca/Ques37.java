package java_oca;

// Output: false true

public class Ques37 {
    public static void main(String[] args) {
        Ques37 ts = new Ques37();
        System.out.print(isAvailable + " ");
        isAvailable = ts.doStuff();
        System.out.println(isAvailable);

    }

    public static boolean doStuff() {
        return !isAvailable;
    }

    static boolean isAvailable = false;
}
