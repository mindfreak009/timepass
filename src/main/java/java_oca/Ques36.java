package java_oca;

public class Ques36 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Duke");
        String str1 = sb.toString();
        String str2 = str1;  // this line needs to be  added to get Output: true
        System.out.println(str1 == str2);
    }
}
