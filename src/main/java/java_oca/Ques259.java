package java_oca;

public class Ques259 {
    public static void main(String[] args) {
        byte number = 100;
        switch (number) {
            case '7' :
                System.out.println("A");
                break;
            case 100:
                System.out.println("B");
                break;

            // Compilation fails in the below line, since the value 200 is beyond the byte range;
            //case 200:
            //    System.out.println("C");
            //    break;
        }
    }
}
