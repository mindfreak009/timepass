package interview;

// two different process don't have a deadlock
//

public class ProgramToDetectDeadlockInClass {

    public static void main(String[] args) {

        boolean b = checkDeadlockProcess();
        if(b) {
            System.out.println("Process is not in deadlock state");
        } else {
            System.out.println("Process is in deadlock state");
        }
    }

   public static boolean checkDeadlockProcess() {

        if(!Thread.interrupted()) {
            processA();
            return true;
        } else if(!Thread.interrupted()) {
            processB();
            return true;
        }

        return false;
   }

    public static void processA() {
        int num = 100;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                    processB();
                System.out.println("t1 running  :: " + Thread.currentThread().getName());
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
    }

    public static void processB() {
        int num = 100;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < num ; i++) {
                    System.out.println("Printing value of i (A) :: " + i);
                }
                processA();
                System.out.println("t2 running :: " + Thread.currentThread().getName());
            }
        };

        Thread t2 = new Thread(r);
        t2.start();
    }
}
