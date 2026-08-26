package java_oca;

// Output ->   7 : 2 : 3

public class Ques186 {
    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        int c = 1;
        int r1 = a * b / c + 1;      // r1 = 7
        int r2 = a / b * c + 1;      // r2 = 2
        int r3 = a * (b / (c + 1));  // r3 = 3

        System.out.print(r1 + " : " +  r2 + " : " + r3);
    }
}
