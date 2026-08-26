package interview_ques.xoriant;

import java.util.ArrayList;
import java.util.List;


// last remaining person in the circle
// int[] arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

// 1, 3, 5, 7 , 9
// 1, 5, 9
// 5, 9
// 5

// 1 kills 2 and handover to 3, 3 kills 4 and handover to 5

public class LuckyAlivePersonInACircle {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // List<Integer> list = List.of(1, 2, 3, 4, 5); // 1 3 5 //
        findLuckyAlivePerson(list);
    }

    public static void findLuckyAlivePerson(List<Integer> list) {

        // List<Integer> ll = new LinkedList<>(); //treat this list as a circular linked list using modulo operator
        List<Integer> result = new ArrayList<>(); //treat this list as a circular Array List using modulo operator

        int originalList = list.size();
        for (int i = 1; i <= originalList; i++) {
            result.add(i);
        }

        System.out.println("result :: " + result);

        int next = 0;
        int i = 0;
        while (result.size() > 1) {
             i = (i + 1) % originalList; // iterate to got to the next in a circular fashion so use modulo
             next+= result.remove(i); //kill the next person and remove them from linkedlist
             //System.out.println("next here :: " +next);
             originalList--; //reduce the size
            //System.out.println("Killed: "+next); // print the person tp see who got killed
        }

        // This logic also works !!
//        for (int j = 0; ll.size() > 1; n--) {
//            j = (j + 1) % n;
//            int next = ll.remove(j);
//            System.out.println("Killed: " + next); // print the person tp see who got killed
//        }
        System.out.println("Final Answer :: " + result.get(0)); //winner remains
        System.out.println("next :: " +next);
    }










// This code was attempted during interview

//    private static int findLastPerson(List<Integer> list) {
//        int remainingElement = -1;
//
//        List<Integer> availableNumbers = new ArrayList<>();
//
//        int count = 0;
//        int index = 0;
//        for (int i = 0; i < list.size(); i++) {
//            count++;
//            availableNumbers.clear();
//            for (int j = i; j < list.size(); j++) {
//                index = (i + j) % list.size();
//                availableNumbers.add(list.get(index));
//                break;
//            }
//            i = availableNumbers.size();
//
//            // count = 0;
//            // System.out.println("count ::: " +count);
//            // i= i+count-1;
//            // availableNumbers.add(list.get(index));
//        }
//
//
//        System.out.println();
//        if (availableNumbers.size() > 1) {
//            remainingElement = availableNumbers.getFirst();
//        }
//        return remainingElement;
//    }
}
