package interview_ques.servicebased.calsoft;

public class InterviewQues4 {
    public static void main(String[] args) {


        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };
        Thread t = new Thread(r);
        t.start();

       // System.out.println(usingFunctionInterface());
    }

//    public static String usingFunctionInterface() {
//        // Using Function functional interface to print "Hello World"
//        // Function<String, Void> printMessage = message -> {
//        Function<String, String> printMessage = message -> {
//            //System.out.println(message);
//            // return null;  // Returning null since the return type is Void
//            return message;
//        };
//
//        printMessage.apply("Hello World from Functional Interface ");
//    }

}
