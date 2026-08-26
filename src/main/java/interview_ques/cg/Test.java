package interview_ques.cg;

class Test {

    static int x = 11;
    private int y = 33;

    public void method1(int x) {
        Test t = new Test();
        this.x = 22;
        y = 44;
        System.out.println("Test.x: " + Test.x); // 22
        System.out.println("t.x: " + t.x);       // 22
        System.out.println("t.y: " + t.y);       // 33
        System.out.println("y: " + y);           // 44
    }
    public static void main(String[] args) {
        Test t = new Test();
        t.method1(5);
    }
}