package java_oca;

class Vehicles {
    String type = "4W";
    int maxSpeed = 100;

    public Vehicles(String type, int maxSpeed) {
        this.type = type;
        this.maxSpeed = maxSpeed;
    }

    public Vehicles() {}
}

class AudiCar extends Vehicles {
    String trans;

    AudiCar(String trans) {           // line n1
        this.trans = trans;
    }

    AudiCar(String type, int maxSpeed, String trans) {
        super(type, maxSpeed);       // line n2
        this.trans = trans;
    }
}

public class Ques7 {
    public static void main(String[] args) {
        AudiCar car1 = new AudiCar("Auto");
        AudiCar car2 = new AudiCar("4W", 150, "Manual");
        System.out.println(car1.type + " " + car1.maxSpeed+ " " +car1.trans);
        System.out.println(car2.type + " " + car2.maxSpeed+ " " +car2.trans);

    }
}
