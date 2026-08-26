package dsa.arrays;

//   Complexity Analysis:
//       Time Complexity: O(N).
//       Space Complexity: O(1).

public class TrapMaximumRainWater_Improved {

    // Using Brute Force Approach
    // Driver code
    public static void main(String[] args) {
        // int[] arr = {3, 0, 2, 0, 4};
        int[] arr =  {1,8,6,2,5,4,8,3,7};   // output should be 49
        int n = arr.length;

        System.out.print(maxWater(arr, n));
    }

    //
    public static int maxWater(int[] arr, int n) {

        // To store the maximum water that can be stored

        int left = 0;
        int right = n-1;
        int msfLeft = 0;
        int msfRight = 0;
        int ans = 0;

        while(left <= right) {
            if(arr[left] <= arr[right]) {
                  if(arr[left] >= msfLeft) {
                      msfLeft = arr[left];
                  } else {
                      ans += msfLeft - arr[left];
                  }
                left++;
            } else {
                if(arr[right] >= msfRight) {
                    msfRight = arr[right];
                } else {
                    ans +=  msfRight - arr[right];
                }
                right--;
            }
        }

        return ans;
    }

}