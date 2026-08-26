package dsa.twopointers;

// Leetcode #556  (Next Greater Element III)
public class NextGreaterElementWithSameDigits {
    public static void main(String[] args) {
        // Sample Input
        String num = "218765";

        // Function Call
        // System.out.println(nextPermutation(num));

        // Function call
        System.out.println(nextGreaterElement(num));
    }

    private static String nextGreaterElement(String str) {
        // converting String to charArray
        char[] arr = str.toCharArray();

        // 1. find first dip
        int i = arr.length-2;
        while(i>=0 && arr[i] >= arr[i+1]) {
            i--;
        }

        if(i==0) {
            return "-1";
        }

        // find just greater than ith index element
        int k = arr.length-1;
        while(arr[i] >= arr[k]) {
            k--;
        }

        // swap i and k
        char temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;

        // concatenate from 0 to ith index
        String res = "";
        for (int j = 0; j <= i; j++) {
            res+= arr[j];
        }

        // concatenate from k to i+1 index (reverse order)
        for (int j = arr.length-1; j >i ; j--) {
            res+= arr[j];
        }

        return res;
    }

//    private static String  nextPermutation(String num) {
//        // Edge cases :
//        // 1. If number of digits is 1 then just return "Not Possible"
//        if(num.length()==1) {
//            System.out.println("Not possible");
//        }
//
//        // 2.  Start from the right most digit and find the
//        //     first digit that is smaller than the digit next to it.
//        for (int i = num.length()-2; i >0 ; i--) {
//            System.out.println("num.charAt(i) :: " + num.charAt(i));
//            System.out.println("num.charAt(i+1) :: " + num.charAt(i+1));
//            if(num.charAt(i) > num.charAt(i-1)) {
//                break;
//            }
//        }
//
//        int i = 0;
//        // If i is 0 that means elements are in decreasing
//        // order. Therefore, no greater element possible.
//                if (i == 0) {
//                    return "Not Possible";
//                }
//
//
//
//    // Find the smallest digit on right side of (i-1)'th
//    // digit that is greater than num.charAt(i-1)
//
//        //  String num = "218765";
//
//        return "";
//    }
}
