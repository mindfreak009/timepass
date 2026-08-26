package java_oca;

// Output:
// 1 3
// 1 3
public class Ques139 {
    public static void main(String[] args) {
        int[][] arr = new int[2][4];

        System.out.println("arr.length :: " + arr.length);
        arr[0] = new int[]{1,3,5,7};
        arr[1] = new int[]{1,3};

        for (int[] a : arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}
