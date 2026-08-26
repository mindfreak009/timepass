package java_oca;

class CD {
    int r;

    public CD(int r) {
        this.r = r;
    }
}

class DVD extends CD {
    int c;
    DVD (int r, int c) {
        // line n1

        // Following code needs to be added:
        super(r);
        this.c = c;
    }
}

public class Ques13 {
    public static void main(String[] args) {

    }
}
