package designpatterns.structural.adapter;

public class ChargerXYZ implements AppleCharger{
    @Override
    public void chargeIPhone() {
        System.out.println("Apple iPhone charged");
    }
}
