package java_oca;

public class Ques55 {
    public static void main(String[] args) {

        String a = "abcd";
        String b = "abcd123";
        String c = "abcd" + "123";
        System.out.println(b==c);

        int iVar = 100;
        float fVar = 100.100f;
        double dVar = 123;
        fVar = iVar;
        // iVar = fVar;
        // fVar = dVar;
        dVar = fVar;
        // iVar = dVar;
        dVar = iVar;
    }
}
