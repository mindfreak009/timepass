package java_oca;

// Output : 3 6 5 6

public class Ques164 {
    int i;
    static int j;

    public static void main(String[] args) {
        Ques164 x1 = new Ques164();
        Ques164 x2 = new Ques164();
        x1.i = 3;
        x1.j = 4;
        x2.i = 5;
        x2.j = 6;

        System.out.println(
                x1.i + " " +
        x1.j + " " +
        x2.i + " " +
        x2.j + " "
        );
    }
}
