package interview_ques.productbased.mastercard;

public class SubstringInArray {
    public static void main(String[] args) {
        // String str = "helloslkhellodjladfjhello";
        // String findStr = "hello";

        String str = "aaaaa";
        String findStr = "aa";
        System.out.println(findSubstringInArray(str, findStr));
        System.out.println(findSubstringInArray2(str, findStr));
        System.out.println(findSubstringInArray3(str, findStr));
    }

    private static int findSubstringInArray(String str, String findStr) {
        return str.split(findStr, -1).length-1;
    }

    public static int findSubstringInArray2(String str, String findStr) {
        String strDestroy = str;
        int numberOfMatches = 0;

        while (strDestroy.contains(findStr)){
            strDestroy = strDestroy.replaceFirst(findStr, "-");
            numberOfMatches++;
        }
        return numberOfMatches;
    }

    private static int findSubstringInArray3(String str, String findStr) {
        int j = 1;
        int count = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'a' && str.charAt(j) == 'a') {
                j++;
                count++;
            } else {
                j++;
            }
        }

        return count;
    }
}
