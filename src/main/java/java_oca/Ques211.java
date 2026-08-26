package java_oca;

// Output : S6
public class Ques211 {
    public static void main(String[] args) {
        String str = "Sweet Sweat";
        String str2 = str.trim().charAt(6) + "" + str.indexOf("Sw", 1);
        System.out.println(str2);
    }
}
