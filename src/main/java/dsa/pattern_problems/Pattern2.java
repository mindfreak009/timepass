package dsa.pattern_problems;

// 1
// 2 3
// 4 5 6
// 7 8 9 10

public class Pattern2 {
    public static void main(String[] args) {
        printPattern(4);
    }

    public static void printPattern(int n){
        int num = 1;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }
}
