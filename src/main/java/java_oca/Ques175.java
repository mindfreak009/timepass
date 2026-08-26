package java_oca;

// Which option represents the state of the num array after successful completion of the outer loop?

//  Answer:
//     num[0][0] = 10;
//     num[1][0] = 10;
//     num[2][0] = 10;


public class Ques175 {
    public static void main(String[] args) {
        int num[][] = new int[3][1];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                num[i][j] = 10;
            }
        }
    }
}
