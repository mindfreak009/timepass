package java_oca;

class LogFileException extends Exception {}
class AccessViolationException extends RuntimeException {}



public class Ques187 {
    public static void main(String[] args) throws LogFileException {
        Ques187 obj = new Ques187();
        try {
            obj.open();
            obj.process();
            // insert code here
        } catch (Exception e) {
            System.out.println("Completed");
        }

    }

    public void process () throws LogFileException{   // added  "throws LogFileException" to avoid CompileTime error
        System.out.println("Processed");
        throw new LogFileException();
    }

    public void open () {
        System.out.println("Opened");
        throw new AccessViolationException();
    }
}
