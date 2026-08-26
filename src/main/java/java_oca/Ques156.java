package java_oca;

import java.io.IOException;

// Output :  I

class MyExceptionn extends RuntimeException { }

public class Ques156 {
    public static void main(String[] args) {
        try {
            method1();
        } catch (MyExceptionn ne) {
            System.out.println("A");
        }
    }

    public static void method1() {
        try {
            throw 3 > 10 ? new MyExceptionn(): new IOException();
        } catch (IOException ie) {
            System.out.println("I");
        } catch (Exception re) {
            System.out.println("B");
        }
    }
}
