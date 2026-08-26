package java_oca;

// We use arrayname.length to determine the number of rows in a 2D array
// because the length of a 2D array is equal to the number of rows it has

public class Ques57 {
    public static void main(String[] args) {
        int num[][] = new int[1][3];
        System.out.println(num.length);
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length ; j++) {
                num[i][j] = 10;
                System.out.println(num[i][j] + i + ":" +j);
            }

        }
    }
}
