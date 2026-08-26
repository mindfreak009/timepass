package java_oca;

// Output :  9 5


class Test {
    int x, y;

    public Test(int x, int y) {
        initialiize(x, y);
    }
    public void initialiize (int x, int y) {
        this.x = x * x;
        this.y = y * y;
    }
}


public class Ques144 {
    public static void main(String[] args) {
        int x = 9, y = 5;
        Test obj = new Test(x, y);
        System.out.println(x + " " + y);
        //  System.out.println(obj.x + " " + obj.y);     // Output : 81 25
    }
}
