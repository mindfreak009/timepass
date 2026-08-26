package java_oca;


// Output:
//    Base
//    DerivedA
//    Base
//    DerivedB

class Basewa {
    public void test() {
        System.out.println("Base ");
    }
}

class DeriveddA extends Basewa {
    @Override
    public void test() {
        super.test();
        System.out.println("DerivedA ");
    }
}

class DeriveddB extends Basewa {
    @Override
    public void test() {
        super.test();
        System.out.println("DerivedB ");
    }
}


public class Ques177 {
    public static void main(String[] args) {
        Basewa b1 = new DeriveddB();
        Basewa b2 = new DeriveddA();
        Basewa b3 = new DeriveddB();
        Basewa b4 = b3;
        b1 = (Basewa) b2;
        b1.test();
        b4.test();
    }
}
