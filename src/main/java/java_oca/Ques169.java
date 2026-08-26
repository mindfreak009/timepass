package java_oca;

// Output:  A B C D E

public class Ques169 {
    public static void main(String[] args) {
        String[][]  arr = {{"A", "B", "C"}, {"D", "E"}};
        System.out.println("length of arr  :: " + arr.length);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                if(arr[i][j].equals("B")) {
                    continue;
                }
            }
            continue;
        }
    }
}
