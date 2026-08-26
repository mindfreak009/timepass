package java_oca;


// Ques. Which line throws ClassCastException ?

class C1 {}
class C2 extends C1 {}
class C3 extends C2 {}

public class Ques193 {
    public static void main(String[] args) {
        C1 obj1 = (C1) new C2();
        C2 obj2 = (C2) new C3();
        // C2 obj3 = (C1) new C1();             // this line throws ClassCastException
        C3 obj4 = (C3) obj2;
    }
}
