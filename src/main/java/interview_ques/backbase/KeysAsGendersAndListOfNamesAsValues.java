package interview_ques.backbase;

// You have an array of Person objects with attributes name, age, and gender.
// Implement a Java method that takes this array and returns a map where the keys
// are genders, and the values are lists of names of persons older than 25.

import java.util.*;

public class KeysAsGendersAndListOfNamesAsValues {
    public static void main(String[] args) {
        String[][] persons = {
                {"Alice", "28", "Female"},
                {"Bob", "22", "Male"},
                {"Charlie", "30", "Male"},
                {"Diana", "26", "Female"},
                {"Eva", "24", "Female"}
        };

        Map<String, List<String>> personsByGender = getPersonsByGender(persons);
        System.out.println(personsByGender);
    }

    // Output:
    // {Male=[Charlie], Female=[Alice, Diana]}

    public static Map<String, List<String>> getPersonsByGender(String[][] persons) {
        Map<String, List<String>> genderMap = new HashMap<>();

        for (String[] person : persons) {
            String name = person[0];
            int age = Integer.parseInt(person[1]);
            String gender = person[2];

            if (age > 25) {
                genderMap.computeIfAbsent(gender, k -> new ArrayList<>()).add(name);
            }
        }
        return genderMap;
    }
}



//  {"Eva", "24", "Female"}
//        Arrays.stream(persons)
//                .forEach(i -> {
//                    if(i > 25)
//                    // char c = Character.isDigit(i)
//                   // if(i == Character.())
//                   // map.put(i, )
//                   if(Character.isDigit(i))
//                }
//    });
