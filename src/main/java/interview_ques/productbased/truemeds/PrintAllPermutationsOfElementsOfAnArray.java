package interview_ques.productbased.truemeds;

public class PrintAllPermutationsOfElementsOfAnArray {
    public static void main(String[] args) {
       int[] arr = {1,2,3};
       int start = 0;
       generatePermutations(arr, start);
    }

    private static void generatePermutations(int[] arr, int currIdx) {
        if(currIdx == arr.length-1) {
            printArrayz(arr);
            return ;
        }

        for (int i = currIdx; i < arr.length; i++) {
             swapElements(arr, i, currIdx);
             generatePermutations(arr, currIdx+1);

             // backtracking
             swapElements(arr, i, currIdx);
        }
    }

    private static void printArrayz(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void swapElements(int[] arr, int start, int i) {
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
    }
}
