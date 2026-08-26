package interviewtime;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// a,10
// b,20
// c,20
// d,5

// 20, 2
// 10, 1
// 5, 1

// select sal from emp
// group by sal;


public class FindMinAndMax {
    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 55, 43, 67};

        int minNumber = arr[0];
        int maxNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            minNumber = Math.min(arr[i], minNumber);
            maxNumber = Math.max(arr[i], maxNumber);
        }

        System.out.println("minNumber:: "+minNumber);
        System.out.println("maxNumber:: "+maxNumber);

        int smallest = arr[0];
        int largest = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > largest) {
                largest = arr[i];
            } else if(arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        System.out.println("smallest :: " +smallest);
        System.out.println("largest :: " +largest);

        List<String> list = Arrays.asList("Hari", "Aakash");
        List<Integer> list2 = Arrays.asList(1, 2,3,7);
        Optional<Integer> max = list2.stream()
                .max((a, b) -> b-a);

        System.out.println(max);

        //     .collect(Collectors.collect(Employee::getSalary).collectingAndThen(Employee:getName))

    }

}
