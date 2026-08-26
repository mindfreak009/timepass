package java_oca;

// Output: 20:20


class Vehiclz {
    int x;

    Vehiclz() {
        this(10);
    }

    Vehiclz(int x ) {
        this.x = x;
    }
}

class Carz extends Vehiclz {
    int y;

    Carz() {
        super(10);
    }

    Carz(int y) {
        super(y);
        this.y = y;
    }

    public String toString() {
        return super.x + ":" +this.y;
    }
}


public class Ques147 {
    public static void main(String[] args) {
        Vehiclz y = new Carz(20);
        System.out.println(y);
    }
}
