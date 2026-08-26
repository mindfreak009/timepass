package java_oca;

public class Ques50 {
    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = new String("java");
        if(str2.equals(str1.toLowerCase())){  // Option 2:
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }

    }
}
