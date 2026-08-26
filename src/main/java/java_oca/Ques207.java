package java_oca;


// Output: B C

public class Ques207 {

    String s;
    public boolean equals(Ques207 str) {
        return this.s.equalsIgnoreCase(str.toString());
    }

    public Ques207(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        String s1 = "Moon";
        Ques207 s2 = new Ques207("Moon");

        if((s1 == "Moon") && (s2.equals("Moon"))) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }

        if(s1.equalsIgnoreCase(s2.s)){
            System.out.println("C");
        } else {
            System.out.println("D");
        }

    }
}
