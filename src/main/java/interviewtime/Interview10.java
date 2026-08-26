package interviewtime;

// Output:  Prakash am I
public class Interview10 {
    public static void main(String[] args) {
        String str = "I am Prakash";
        stringManipulate(str);
    }

    private static void stringManipulate(String str) {
        String[] arr = str.split(" ");
        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

    }


}
