package java_oca;

public class Ques262 {
    public static void main(String[] args) {
        Integer[] a = new Integer[2];
        // the below line throws NullPointerException, because when we try to perform an arithmetic operation on the null element,
        // the compiler throws NullPointerException.....
        // System.out.println(a[1] + a[0]);

        int[] b = new int[2];
        System.out.println(b[0] + b[1]);
    }
}
