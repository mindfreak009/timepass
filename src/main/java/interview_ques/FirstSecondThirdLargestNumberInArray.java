package interview_ques;


// Time complexity: O(N)
public class FirstSecondThirdLargestNumberInArray {
    public static void main(String[] args) {

       // A constant holding the minimum value an int can have, -2^31.
        int max1 = Integer.MIN_VALUE;

        // A constant holding the maximum value an int can have, 2^31-1.
        int min = Integer.MAX_VALUE;

        // int arr[] = {3, 2, 1, 56, 10000, 167};
        int arr[] ={1, 345, 234, 21, 56789, 345, 56789};
        // int arr[] ={1, 1345, 234, 2122, 56789};

        int max = arr[0];
        int secondMax = 0;
        int thirdMax = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                // shift down
                thirdMax = secondMax;
                secondMax = max;
                max = arr[i];  // 345
            } else if (arr[i] > secondMax && arr[i] != max) { //  && arr[i] < maxHighest) {
                // update second max but avoid duplicate of max
                thirdMax = secondMax;
                secondMax = arr[i]; // 234
            } else if(arr[i] > thirdMax && arr[i] != max && arr[i] != secondMax){
                // update third max but avoid duplicates of max & second
                thirdMax = arr[i]; // 21
            }
        }

        System.out.println("Max highest :: " +max);
        System.out.println("Second highest :: " +secondMax);
        System.out.println("Third highest :: " +thirdMax);
    }
}
