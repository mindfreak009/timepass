//package multithreading;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class Question {
//    public static void main(String[] args) {
//        String str1 = "12ABC45XY";
//        String str2 = "23XY59";
//        List<String> list1 = new ArrayList<String>(
//                Arrays.asList(str1.split("")));
//        List<String> list2 = new ArrayList<String>(
//                Arrays.asList(str2.split("")));
//
//        List<String> l3 =list1.stream().filter(x -> list2.stream().co(x)).collect(Collectors.toList());
//
//
////        List<String> collect = Stream.of(str1).filter(strr ->
////                Stream.of(str2).mapToInt(Integer::valueOf)
////                        .collect(() -> Collectors)
////                        .contains(str1)).collect(Collectors.toList());
////        System.out.println("collect ::: " +collect);
//
////        List<Integer> list1 = new ArrayList<>();
////        List<Integer> list2 = new ArrayList<>();
//        for(int i = 0; i<str1.length(); i++) {
//            char c = str1.charAt(i);
//            if(Character.isDigit(c)) {
//                list1.add(Character.getNumericValue(c));
//            }
//        }
//        for(int j = 0; j<str2.length(); j++) {
//            char c = str2.charAt(j);
//            if(Character.isDigit(c)) {
//                list2.add(Character.getNumericValue(c));
//            }
//        }
//
//        System.out.println(list1);
//        System.out.println(list2);
//
//
//        int add = 0;
//        int count = 0;
//        Set<Integer> set = new HashSet<>();
//        for(int k=0; k<list1.size(); k++) {
//            for(int l=0; l<list2.size(); l++) {
//                if(list1.get(k)==list2.get(l)) {
//                    ++count;
//                    if(count ==1) {
//                        add = list1.get(k) + list1.get(k);
//                    }
//                    break;
//                }
//            }
//        }
//        System.out.println("add :: " +add);
//    }
//}
