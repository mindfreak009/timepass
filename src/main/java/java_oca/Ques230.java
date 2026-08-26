package java_oca;

public class Ques230 {

    static float height;

    public float jump(long x) {
        System.out.println("Jump1");
        return height + x;
    }

    public float jump(int x) {
        System.out.println("Jump2");
        return height + x;
    }

    public float jump(float x) {
        System.out.println("Jump3");
        return height + x;
    }

    public static void main(String[] args) {
        Ques230 obj = new Ques230();
        obj.jump(10);
        obj.jump(1000000000L);
        obj.jump(10.01f);
    }
}
