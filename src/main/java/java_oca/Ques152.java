package java_oca;

// Output: -1
//         because in the last iteration, it goes to "sat" and then since there is no break statement
//         it would execute the next statement following "sat" which is "sun" and pick the value of wd as -1.
public class Ques152 {
    public static void main(String[] args) {
        int wd = 0;
        String[] days = {"sun", "mon", "wed", "sat"};

        for (String s: days) {
            switch (s) {
                case "sat":
                case "sun":
                    wd -= 1;
                    break;
                case "mon":
                    wd -= 1;
                    break;
                case "wed":
                    wd += 2;
            }
        }
        System.out.println(wd);
    }
}
