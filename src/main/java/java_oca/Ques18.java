package java_oca;

// Which code prints output:
// red:blue:small:medium

public class Ques18 {
    public static void main(String[] args) {
        String shirts[][] = new String[2][2];
        shirts[0][0] = "red";
        shirts[0][1] = "blue";
        shirts[1][0] = "small";
        shirts[1][1] = "medium";

        // Option C:
        for (String[] str: shirts){
            for (String s : str) {
                    System.out.print(s + ":");
            }
        }

        System.out.println();
        System.out.println("===============================");

        // Option D:
        // This would throw "ArrayIndexOutOfBoundsException" since
        for (int index = 0; index <=2; ) {
            for (int idx = 0; idx <=2 ; ) {
                System.out.print(shirts[index][idx] + ": ");
                idx++;
            }
            index++;
        }
    }
}
