package interview_ques;

public class PrintAnyTables_PurabSanwa_Sukudai {
    public static void main(String[] args) {
        long n = 1004500000;
        System.out.println("Table of : " +n);
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));

        }
        System.out.println("=======================================");
        System.out.println("5*1=5");
        System.out.println("5*2=10");
        System.out.println("5*3=15");
        System.out.println("5*4=20");
    }
}
