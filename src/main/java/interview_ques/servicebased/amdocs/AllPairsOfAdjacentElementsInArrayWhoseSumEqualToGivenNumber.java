package interview_ques.servicebased.amdocs;

// Time Complexity: O(N)
// Space Complexity: O(N)

public class AllPairsOfAdjacentElementsInArrayWhoseSumEqualToGivenNumber {
    public static void main(String[] args) {
      //  int arr[] = {1,5,7,-1};
        int arr[] = {3,3,2,4,1,5};
        int sum = 6;

        pairsOfElementsWhoseSumIsEqual(arr, sum);
    }

    private static void pairsOfElementsWhoseSumIsEqual(int arr[], int sum) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + arr[i] == sum) {
                sb.append("(");
                sb.append(arr[i]);
                sb.append(",");
                sb.append(arr[i-1]);
                sb.append(")");
                sb.append("\t");
            }
        }
        System.out.println(sb);
    }
}
