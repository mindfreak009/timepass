package java_oca;

// Output:
// Compilation fails at line n2
public class Ques19 {
    void readCard(int cardNo) throws Exception {
        System.out.println("Reading Card");
    }

    void checkCard(int cardNo) throws RuntimeException {  // line n1
        System.out.println("Checking Card");
    }

    public static void main(String[] args) {
        Ques19 ex = new Ques19();
        int cardNo = 12344;
        // ex.readCard(cardNo);            // line n2
        ex.checkCard(cardNo);           // line n3

    }
}
