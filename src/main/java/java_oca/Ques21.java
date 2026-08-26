package java_oca;

// Which modification enables the code to print "TrueDone" ?

// A. Replace line 15 with String opt = "true"; Replace line 17 with case "true"
// B. Replace line 15 with boolean opt = l; Replace line 17 with case 1:
// C. At line 19, remove the break statement
// D. Remove the default section

public class Ques21 {
    public static void main(String[] args) {
        // boolean is not an accepted form of data type, hence replace it with String data type.
        // So option A is the answer

        String opt = "true";          // boolean opt = true;
        switch (opt) {
            case "true":              //  case true :
                System.out.println("True");
                break;
            default:
                System.out.println("*******");
        }
        System.out.println("Done");
    }
}
