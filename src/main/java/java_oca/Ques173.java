package java_oca;

// what modification enables the code to print 54321 ?


public class Ques173 {
    public static boolean isAvailable(int x) {
        return --x > 0 ? true : false;
    }
    public static void main(String[] args) {
        int x = 6;
        while(isAvailable(x)) {
            System.out.print(x);   // Replace this line with System.out.print(--x);
        }
    }
}
