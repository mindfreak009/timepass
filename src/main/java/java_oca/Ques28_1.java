package java_oca;

// What would be the output:
// A. 3 4 5 6
// B. 3 4 3 6
// C. 5 4 5 6
// D. 3 6 4 6

// Answer: 5 4 5 6

public class Ques28_1 {
    static int i;
    int j;

    public static void main(String[] args) {
        Ques28_1 x1 = new Ques28_1();
        Ques28_1 x2 = new Ques28_1();
        x1.i = 3;
        x1.j = 4;
        x2.i = 5;
        x2.j = 6;

        System.out.println(
                x1.i + "  " +
                x1.j + " " +
                x2.i + " " +
                x2.j + " "
        );

    }
}
