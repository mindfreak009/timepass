package java_oca;

// Output:
//     c = null
//     b = false
//     f = 0.0

public class Ques220 {

    Character c;
    boolean b;
    float f;
    void printAll() {
        System.out.println("c = " + c);
        System.out.println("b = " + b);
        System.out.println("f = " + f);
    }
    public static void main(String[] args) {
        Ques220 f = new Ques220();
        f.printAll();
    }
}
