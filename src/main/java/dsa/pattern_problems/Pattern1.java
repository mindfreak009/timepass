package dsa.pattern_problems;

// 1
// 1 2
// 1 2 3
// 1 2 3 4

public class Pattern1 {
    public static void main(String[] args) {
        printPattern(4);
    }

    public static void printPattern(int n){
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
