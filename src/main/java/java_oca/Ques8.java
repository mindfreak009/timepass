package java_oca;

class Caller {
   private void init() {
       System.out.println("Initialized");
   }

   private void start() {
       init();
       System.out.println("Started");
   }
}

public class Ques8 {
    public static void main(String[] args) {
            Caller caller = new Caller();
            // Compilation fails at line n1 because it is trying to access the private method

            // caller.start();                 // line n1
            // caller.init();                  // line n2
    }
}
