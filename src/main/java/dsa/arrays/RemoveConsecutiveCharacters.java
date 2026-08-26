package dsa.arrays;

public class RemoveConsecutiveCharacters {
    public static void main(String[] args) {
        String str = "aaabb";
        removeConsecutiveCharacters(str);
    }

    private static void removeConsecutiveCharacters(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < str.length(); i++) {
            char c1 = str.charAt(i-1);
            char c2 = str.charAt(i);
            if(c1 != c2) {
                sb.append(c1);
                c1 = c2;
            }
            //sb.append(c1);
        }
        System.out.println(sb);
    }
}
