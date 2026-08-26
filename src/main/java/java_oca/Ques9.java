package java_oca;


// Any amount of electricity used by a customer (represented by an instance of the Customer class) must
// contribute to the customer's bill (represented by the member variable bill) through the useElectricity() method.

// An instance of the Customer class should never be able to tamper with OR decrease the value of the member variable bill.

// How should you write methods in the ElectricAccount class at line n1 so that the member variable bill is
// always equal to the value of the member variable kWh multiplied by the member variable rate ?


class Customer {
    ElectricAccount account = new ElectricAccount();

    public void useElectricity(double kWh) {
        account.addKWh(kWh);
    }
}

class ElectricAccount {
    private double kWh;
    private double rate = 0.07;
    private double bill;

    // line n1
    // Answer:
        public void addKWh(double kWh) {
            if(kWh > 0) {
                this.kWh += kWh;
                this.bill = this.kWh * this.rate;
            }
        }

//        public void addKWh(double kWh) {
//            this.kWh += kWh;
//            this.bill = this.kWh * this.rate;
//        }

    // This method is WRONG, since it has private access modifier:

    //    private void addKWh(double kWh) {
    //        if(kWh > 0) {
    //            this.kWh += kWh;
    //            this.bill = this.kWh * this.rate;
    //        }
    //    }


}

public class Ques9 {
    public static void main(String[] args) {

    }
}
