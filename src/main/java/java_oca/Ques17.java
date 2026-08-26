package java_oca;

class CheckingAccount {
    public int amount;

    public CheckingAccount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void changeAmount(int x) {
        System.out.println("value recd ::: " +x);
        // amount += x;
        amount = amount + x;
        System.out.println("amount here :: " + amount);
    }
}


public class Ques17 {
    public static void main(String[] args) {
        CheckingAccount acct = new CheckingAccount((int)Math.random()*1000);
        // line n1
        // all the below 3 options are correct
        acct.setAmount(62); // 1.
        // acct.amount = 0;   // 2;
        // acct.changeAmount(-acct.amount); // 3.

        //acct.changeAmount(0);               Wrong option:

        System.out.println(acct.getAmount());
    }
}
