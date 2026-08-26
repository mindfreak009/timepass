package switchstatementevolution;

public class EvolutionOfSwitchExpression {
    public void switchCaseExampleJava7() {
        int value = 3;
        switch (value) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            default:
                System.out.println("Unknown");
        }
    }

    public void switchCaseExampleJava8() {
        String day = "Tuesday";
        switch (day) {
            case "Monday":
                System.out.println("Monday");
                break;
            case "Tuesday":
                System.out.println("Monday");
                break;
            case "Wednesday":
                System.out.println("Monday");
                break;
            default:
                System.out.println("Unknown");
        }
    }

    enum DAYS { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};
    public void switchCaseEnumExampleJava8() {
        DAYS days = DAYS.SUNDAY;
        switch (days) {
            case MONDAY:
                System.out.println("Monday");
                break;
            case TUESDAY:
                System.out.println("Monday");
                break;
            case SUNDAY:
                System.out.println("Monday");
                break;
            default:
                System.out.println("Unknown");
        }
    }

    public String returnUsingArrowInJava12(String day) {
        return switch (day) {
            case "Monday" -> "Monday";
            case "Tuesday" -> "Tuesday";
            case "Wednesday" -> "Wednesday";
            case "Thursday" -> "Thursday";
            case "Friday" -> "Friday";
            case "Saturday" -> "Saturday";
            default -> "Unknown";
        };
    }


    public String multipleCaseInJava12(String day) {
        return switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "weekdays";
            case "Saturday", "Sunday" -> "weekends";
            default -> "Unknown";
        };
    }

//    public String returnUsingBreakInJava12() {
//        String day = "Tuesday";
//        return switch(day) {
//            case "Monday":
//                break "weekdays";
//
//            case "Sunday":
//                break "weekend";
//            default:
//                System.out.println("Unknown");
//        };
//    }

    public String returnUsingYieldKeywordInJava13() {
        String day = "Tuesday";
        return switch (day) {
            case "Monday":
                yield "Monday";
            case "Tuesday":
                yield "Tuesday";
            default:
                yield "Unknown";
        };
    }

//    public String patternMatchingExampleJava17(Object obj) {
//            return switch (obj) {
//                case Integer i -> "This is an integer";
//                case String s-> "This is a String";
//                case Double i -> "This is a Double";
//                case "Saturday", "Sunday" -> "weekends";
//                default -> "Unknown";
//            };
//    }

//         public String guardedPatternExampleJava17(Object obj) {
//            return switch (obj) {
//                case Integer i -> "This is an integer";
//                case String s-> "This is a String";
//                case Student e && e.getSalary().equals("IT") -> "It is an IT Employee";
//                case "Saturday", "Sunday" -> "weekends";
//                default -> "Unknown";
//            };
//         }

//         public String guardedPatternExampleJava17(Object obj) {
//             return switch (obj) {
//                case Integer i -> "This is an integer";
//                case String s-> "This is a String";
//                case Student e && e.getSalary().equals("IT") -> "It is an IT Employee";
//                case null -> "NPE";
//                case "Saturday", "Sunday" -> "weekends";
//                default -> "Unknown";
//            };
//         }

    public static void main(String[] args) {

    }
}

/**
 * jdk7  -> Integer
 * jdk8  -> String, ENUM
 * jdk12 ->
 *          break
 *          arrow function
 *          multiple values in case
 * jdk13 -> break keyword was replaced with yield keyword
 * jdk14 -> preview feature to permanent
 *
 * jdk17 -> (2021 Sep)
 *           pattern matching ->
 *                               You can match pattern in case label. (You can pass object to case)
 *           Gourded pattern ->
 *                              You can pass conditional statement inside case value
 *           Null Case ->
 *                        you can pass null case
 */








