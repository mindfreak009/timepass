package java_oca;

class MyException extends RuntimeException {}

public class Ques71 {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("A");
        }
    }

    public static void method1() { // line n1
        try {
            throw Math.random() > 0.5 ? new MyException() : new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("B");
        }
    }
}
