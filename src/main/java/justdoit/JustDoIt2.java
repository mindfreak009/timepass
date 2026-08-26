package justdoit;

// public class JustDoIt2 {
  //  public static void main(String[] args) {
//       String s =  "My name is @satyajit";
//        s = s.replace("@" , "");
//        System.out.println(s);

//        String str = "";
//        for (int i = 0; i < s.length(); i++) {
//            int asciiVal =  s.charAt(i);
//            if(asciiVal >= 65 && asciiVal<= 122) {
//                str = str + (char) asciiVal + " ";
//            }
//        }
//        System.out.println(str);

//    }
// }


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JustDoIt2 {
    public static void main(String[] args) {

        int[] arrz = {3,5,6,9,0,8,0,9,156,0};

//        Object[] arrayz = Stream.concat(
//                Arrays.stream(arrz).boxed().filter(i -> i == 0),
//                Arrays.stream(arrz).boxed().filter(i -> i != 0)
//        ).toArray(Integer[]::new);
//        System.out.println("arr ::: " + Arrays.toString(arrayz));
        System.out.println("=========================================================");

        int startIndex = 0;
        for (int i = 0; i < arrz.length; i++) {
            if(arrz[i] == 0) {
                for (int k = startIndex; k < i; k++) {
                    int tenp = arrz[k];
                    arrz[k] = arrz[i];
                    arrz[i] = tenp;
                }
                startIndex++;
            }
        }
        System.out.println("arr ::: " + Arrays.toString(arrz));
        System.out.println("=========================================================");

        int[] numArr = {2,4,7,8,9};
        List<List<Integer>> listOfLists = new ArrayList<>();

        for (int i = 0; i < numArr.length - 1 ; i++) {
            List<Integer> list = new ArrayList<>();
            int first = numArr[i];
            int second = numArr[i+1];

            for (int j = 0; j <= 1 ; j++) {
                list.add(first);
                list.add(second);
                break;
            }

            listOfLists.add(list);
        }

        System.out.println(listOfLists);

        // Given date string
        String dateString = "2023-05-30T15:20:21";

        // Parse the date string into a LocalDateTime object
        LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        // Format the LocalDateTime object into a string with the desired format
        String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Print the formatted date
        System.out.println(formattedDate); // Output: 2023-05-30 15:20:21




        int[] arr = {1, 2, 0, 4, 0, 9, 0, 5, 0, 6};

        // Shift zeros to the beginning while maintaining the order of non-zero elements
        int nonZeroIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[nonZeroIndex];
                arr[nonZeroIndex] = temp;
                nonZeroIndex++;
            }
        }

        // Print the updated array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

