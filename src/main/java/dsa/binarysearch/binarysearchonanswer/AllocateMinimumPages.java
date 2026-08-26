package dsa.binarysearch.binarysearchonanswer;

// Difficulty: Medium

// Given an array arr[], where arr[i] represents the number of pages in the i-th book, and an integer k denoting the total number
// of students, allocate all books to the students such that:
//    • Each student gets at least one book.
//    • Books are allocated in a contiguous sequence.
//    • The maximum number of pages assigned to any student is minimized.
// If it is not possible to allocate all books among k students under these conditions, return -1.

// Examples:
// Input: arr[] = [12, 34, 67, 90], k = 2
// Output: 113

// Explanation: Books can be distributed in following ways:
// [12] and [34, 67, 90] - The maximum pages assigned to a student is  34 + 67 + 90 = 191.
// [12, 34] and [67, 90] - The maximum pages assigned to a student is 67 + 90 = 157.
// [12, 34, 67] and [90] - The maximum pages assigned to a student is 12 + 34 + 67 = 113.
// The third combination has the minimum pages assigned to a student which is 113.

// Input: arr[] = [15, 17, 20], k = 5
// Output: -1
// Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.

// Input: arr[] = [22, 23, 67], k = 1
// Output: 112
// Explanation: Since there is only 1 student, all books are assigned to that student. So, maximum pages assigned to a student is 22 + 23 + 67 = 112.

// Time Complextiy: O(N + N*log^2K)
public class AllocateMinimumPages {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println("Final answer: " + findPages(arr, k));
    }

    public static int findPages(int[] arr, int k) {
        int start = 0;
        int end = 0;

        // find search spaces
        for (int a : arr) {
            start = Math.max(start, a);
            end+= a;
        }

        // System.out.println("start::: " +start);
        // System.out.println(end);

        int ans = -1;
        while(start <=end) {
            int mid = start + (end-start)/2;
            if(allocationPossible(arr, mid, k)) {
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }

    private static boolean allocationPossible(int[] arr, int maxPages, int students) {
        int studentCount = 1;
        int pages = 0;

        for (int a : arr) {
            pages+= a;
            // If pages is greater than maxPages, we are just resetting it and giving it to other student.
           if(pages > maxPages) {
               pages = a;
               studentCount++;
           }
           if(studentCount > students){
               return false;
           }
        }
        return true;
    }
}
