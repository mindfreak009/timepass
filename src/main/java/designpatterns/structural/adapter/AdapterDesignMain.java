package designpatterns.structural.adapter;

// Adapter Design is a behavioral pattern

public class AdapterDesignMain {
    public static void main(String[] args) {

        AppleCharger appleCharger = new ChargerXYZ();
        Iphone13 iphone13 = new Iphone13(appleCharger);
        iphone13.chargeIPhone();
    }
}
