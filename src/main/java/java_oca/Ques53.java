package java_oca;

class Vehicle {
    int x;
    Vehicle() {
        this(10);
    }
    Vehicle(int x) {
        this.x = x;
    }
}
class Car extends Vehicle {
    int y;
    Car() {
        super();
        // this(20);      Compilation fails here...
    }
    Car(int y) {
        this.y = y;
    }

}


public class Ques53 {
}
