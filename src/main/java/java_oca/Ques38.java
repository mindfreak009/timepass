package java_oca;

// And given the requirements:
// If the value of the qty variable is greater than or equal to 90, discount = 0.5
// If the value of the qty variable is between 80 and 90, discount = 0.2

public class Ques38 {
    public static void main(String[] args) {
        double discount = 0;
       // int qty = Integer.parseInt(args[0]);
        int qty = 89;
        // line n1
        // Option 1:
        if(qty >=90) {discount = 0.5; }
        if(qty >80 && qty < 90) {discount = 0.2; }

        // Option 2:
        discount = (qty >=90) ? 0.5 : (qty > 80) ? 0.2 :0;

        System.out.println(discount);
    }
}
