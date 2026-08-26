package java_oca;

// Ouput: 1 2 3 4 followed by an IndexOutOfBoundsException

// •  1 2 3
// •  1 2 3 4
// •  Compilation fails.

public class Ques51 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int i = 0;
        do {
            System.out.println(arr[i] + " ");
            i++;
        } while (i < arr.length +1);
    }
}
