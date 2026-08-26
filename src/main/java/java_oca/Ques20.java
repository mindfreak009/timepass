package java_oca;

// What modification enables the code to print 54321 ?

public class Ques20 {
    public static void main(String[] args) {
        int x = 5;
        while(isAvailable(x)) {
            System.out.print(x);
            // Ans::
            // We have to add the below line of code
            x--;
        }
    }

    public static boolean isAvailable(int x) {
        return x --> 0 ? true : false;
        // return (x > 0) ? false : true;
    }
}
