package test;

public class CalculateCharactersExcludingSpaces {
    public static void main(String[] args) {
        String str = "I am a dog";
        int count = 0;
        int countWord = 0;
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isWhitespace(str.charAt(i))){
                count++;
            }
            if(Character.isWhitespace(str.charAt(i)))
                countWord++;
        }
        System.out.println(count);
        System.out.println(countWord+1);
    }
}
