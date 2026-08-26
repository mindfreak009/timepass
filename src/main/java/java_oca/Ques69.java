package java_oca;

public class Ques69 {
    public static void main(String[] args) {
       // byte x = 1;
       // short x = 1;
       // char x = 1;
       // Integer x = new Integer("1");  // this is deprecated since JDK 9.
        Integer x = Integer.valueOf(String.valueOf("1"));
      //  String x = "1";    // String is not supported
       // long x = 1;      // long is not supported
        switch (x) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
        }
    }
}
