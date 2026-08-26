package java_oca;

// Output:  4231

public class Ques143 {
    public static void main(String[] args) {
        int[][] n = {{1,3}, {2,4}};

        System.out.println(n.length);

        for (int i = n.length-1; i >=0 ; i--) {
            for (int j = n[i].length -1; j >= 0 ; j--) {
                System.out.print(n[i][j]);
            }

        }
    }
}
