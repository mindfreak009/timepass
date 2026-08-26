package durgasoft_java;

public class PrintNumbersInAscendingOrder {

    public static void main(String[] args) {

        int[] num = {1,2,3,4,5,6,7,8,9,10};
        int count = 0;
        for (int i=0; i<num.length;i++) {
            count++;
            for (int j=i; j<=count; j++){
                System.out.println("j ::: " +j);
                count++;
            }
        }
    }
}
