package dsa.vvip;


// Time complexity : O(N)

public class SmallestElementInUnsortedArray {
    public static void main(String[] args) {

        int[] arr = {3, 55, 21, 66, 2, 100, -1, 0, -3};
        int ans = smallestElement(arr);
        System.out.println("ans :: " +ans);
    }

    private static int smallestElement(int[] arr) {
        int smallest = arr[0];

        // this is also correct
        for (int i = arr.length-1; i >=0; i--) {
            if(arr[i]<smallest) {
               smallest  = arr[i];
            }
        }
        // this is also correct
        for (int i = 0; i< arr.length; i++) {
            if(arr[i]<smallest) {
                smallest  = arr[i];
            }
        }
        return  smallest;
    }
}
