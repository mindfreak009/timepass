package interview_ques.mastercard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MasterCardInterviewQuestion4 {
    public static void main(String[] args) {
        String[] arr = {"abc", "abcd", "ab", "afg", "adb"};

//       boolean result =  isAscendingOrder2(arr);
//        System.out.println("final result :: " +result);

        for (String str : arr) {
            boolean isAscending = isAscendingOrder(str);
            if (!isAscending) {
                System.out.println(str + " : " + false);
            }
        }
    }

    public static boolean isAscendingOrder(String str) {
        // Using str.length()-1 to prevent ArrayIndexOutOfBoundsException
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) > str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAscendingOrder2(String[] arr) {
        List<String> stringList = new ArrayList<>();
        for(String res :  arr) {
            stringList.add(res);
        }
        System.out.println("stringList :: " +stringList);

        // creating a new List to store sorted String
        List<String> ascendingList = new ArrayList<>(stringList);

        // The sort() method would have a time complexity of O(n log n)
        Collections.sort(ascendingList);
        System.out.println("ascendingList :: " +ascendingList);

        if(stringList.contains(ascendingList)) {
            return true;
        } else {
            System.out.println("Reached here ::: ");
            return false;
        }

    }

}