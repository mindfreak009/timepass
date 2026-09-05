package interview_ques.servicebased.cognizant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Output: Pi, Hr, Ah, L
public class SPGlobalCodingQuestion {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Shiva Tripathi", "Harry Porter", "Aman Singh", "Lenovo");

        System.out.println(findResultsUsingStreams(list));
        System.out.println(findResults(list));
        System.out.println(getFirstCharAndLastCharFromString(list));
    }

    public static String getFirstCharAndLastCharFromString(List<String> list) {
        return list.stream()
                .map(s -> {
                    String[] words = s.split(" ");
                    return words.length > 1
                            ? "" + words[0].charAt(0) + words[1].charAt(words[1].length() - 1)
                            : words[0].substring(0, 1);
                })
                .collect(Collectors.joining(","));
                //.forEach(System.out::println);
    }

    public static String findResultsUsingStreams(List<String> list) {
        return list.stream()
                .map(str -> {
                    String[] words = str.split(" ");
                    if (words.length > 1) {
                        String firstLetter = words[0].substring(0, 1);
                        String lastLetter = words[1]
                                .substring(words[1].length() - 1);

                        return firstLetter + lastLetter;
                    }
                    return str.substring(0, 1);

//  this code also works
//                            return words.length > 1
//                                    ? "" + words[0].charAt(0)
//                                    + words[words.length - 1].charAt(words[words.length - 1].length() - 1)
//                                    : String.valueOf(str.charAt(0));
                })
                .collect(Collectors.joining(", "));
    }

    public static String findResults(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String[] s2 = list.get(i).split(" ");
            String first = s2[0];
            String second = "";

            if (s2.length > 1) {
                second = s2[1];
            }

            if (!first.isEmpty() && !second.isEmpty()) {
                String firstChar = first.substring(0, 1);
                String secondChar = second.substring(second.length() - 1);
                sb.append(firstChar);
                sb.append(secondChar);
                sb.append(",");
            } else if (second.isEmpty()) {
                sb.append(first.substring(0, 1));
            }
        }
        return sb.toString();
    }


    }

