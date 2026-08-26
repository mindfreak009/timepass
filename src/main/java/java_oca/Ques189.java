package java_oca;


// Output:  The program fails to compile due to the unhandled E1 exception.


class E1 extends Exception {}
class E2 extends RuntimeException {}

public class Ques189 {

    public void m1() {
        System.out.println("m1. accessed");
       //  throw new E1();                        // this line would give Compilation error.
    }

    public void m2() {
        System.out.println("m2. accessed");
        throw new E2();
    }

    public static void main(String[] args) {
        int level = 1;
        Ques189 obj = new Ques189();

        if(level <= 5 && level >= 3) {
            obj.m1();
        } else {
            obj.m2();
        }
    }
}
