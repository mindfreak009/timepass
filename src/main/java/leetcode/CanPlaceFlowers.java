package leetcode;

// Difficulty level : Easy

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] arr = {1,0,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(arr, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int curr = flowerbed[0];
        int next = 0;

        int i = 0;
        boolean b = false;
        for(int j=1; j<flowerbed.length; j=j+2) {
            if(flowerbed[i] != flowerbed[j]) {
                b = true;
            }
            i = i+2;

        }
        return b;
    }
}
