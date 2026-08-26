package java_oca;

// Ques.  Which two array initialization statements are valid ? (Choose two)

public class Ques192 {
    public static void main(String[] args) {

        // Option 1:
        // int[] array = new int[3] {1,2,3};                     // Invalid

        // Option 2:
        int[] array = new int[3] ;                               // Valid
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;

        // Option 3:
        // int array[3] = new int[]{1,2,3};                      // Invalid

        // Option 4:
        // int[] array1 = new int[3]; array = {1,2,3};          // Invalid

        // Option 5:
        int array2[] = new int[]{1,2,3};                       // Valid


    }
}
