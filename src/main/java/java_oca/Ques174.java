package java_oca;


// Output:  A ClassCastException is thrown only at line n1


class X {
    public void test() {
        System.out.println("X");
    }
}

class Y extends X {
    public void test() {
        System.out.println("Y");
    }
}

class Z extends X {
    @Override
    public void test() {
        super.test();
        System.out.println("C");
    }
}


public class Ques174 {
    public static void main(String[] args) {
        X b1 = new X();
        X b2 = new Z();
        X b3 = (Y) b2;                    // line n1
        b1 = (X) b2;                      // line n2
        b1.test();
        b2.test();

    }
}
