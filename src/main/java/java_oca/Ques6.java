package java_oca;


abstract class Planets {
    protected void revolve() {}      // line 1
    abstract void rotate();          // line 2
}

class Earth extends Planets {
    public void revolve(){}             // line 3

    protected void rotate() {}     // line 4

}


public class Ques6 {
    public static void main(String[] args) {

    }
}
