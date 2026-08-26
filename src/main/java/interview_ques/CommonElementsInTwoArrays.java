package interview_ques;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonElementsInTwoArrays {
    public static void main(String[] args) {
        int[] arr1  = {1,2,3,4,5,4,5};
        int[] arr2  = {4,5,6,7,8,4,5};

        int[] newArr = new int[Math.min(arr1.length, arr2.length)];
        int resultIndex = 0;

        System.out.println("New Array length ::: " + newArr.length);

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i] == arr2[j]) {
                    newArr[resultIndex++] = arr1[i];
                    break;
                }
            }
        }

        ;
        System.out.println(Arrays.toString(Arrays.copyOf(newArr, resultIndex)));

        List<Integer>  list = Arrays.stream(arr1)
                .filter(arr1Num -> Arrays.stream(arr2)
                        .anyMatch(arr2Num -> arr2Num == arr1Num)).boxed().collect(Collectors.toList());
        System.out.println("common elements ::: " +list);
    }
}
