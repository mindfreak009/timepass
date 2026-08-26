package java_oca;

// Output :
// true false true
public class Ques60 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello");
        int a = 20;
        String d = "hello";
        System.out.println(d.contentEquals(sb));  // contentEquals() method is used to check String with StringBuilder.
        System.out.println(sb.equals(d)); // this line prints false, becoz StringBuilder does not override equals() method
        System.out.println(sb.toString().equals(d));
    }
}
