package interview_ques.altimetrik;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberProcessor {
    public static void main(String[] args) {

        // Problematic code
        List<Integer> sourceList =
                IntStream.range(0,1000).boxed().toList();
        List<Integer> processedList = new ArrayList<>();
        sourceList.parallelStream().forEach(num -> {
            processedList.add(num*2);
        });

        // Issues in the above code:
        // The parallelStream() uses multiple threads. Every thread can see the same processedList.
        //          Thread 1 ----+
        //                       |
        //          Thread 2 ----+----> processedList
        //                       |
        //          Thread 3 ----+

        // So processedList is shared state.
        //   ●  forEach() executes your lambda on multiple threads.
        //   ●  Every thread calls processedList.add(...).
        //   ●  All threads are modifying the same ArrayList.

        // Corrected code:
        List<Integer> finalResult = sourceList
                .parallelStream()
                .map(num -> num * 2)
                .collect(Collectors.toList());
        System.out.println("finalResult ::" + finalResult);

        // What solves it is avoiding mutation of a shared object and letting the stream framework manage the result collection.
        // Now there is no shared list for worker threads to modify.
        // Internally, the stream implementation does something conceptually like this:
        // Thread 1 -> [0, 2, 4]
        // Thread 2 -> [6, 8, 10]
        // Thread 3 -> [12, 14, 16]

        // Each thread has its own private list.
        //
        // After all threads finish, the framework safely combines them:
        // [0,2,4]  +
        // [6,8,10] +
        // [12,14,16]
        //      |
        //      v
        // [0,2,4,6,8,10,12,14,16]

        // No thread is modifying the same list concurrently.


    }
}
