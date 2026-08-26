package java_oca;

// Output:
// A B C

class A {
    public A() {
        System.out.println("A");
    }
}

class B extends A {
    public B() {                    // line n1
        System.out.println("B");
    }
}

class C extends B {
    public C() {                   // line n2
        System.out.println("C");
    }
}


public class Ques27 {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c);
    }
}
