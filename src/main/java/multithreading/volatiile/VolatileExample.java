package multithreading.volatiile;

// In general, every thread keeps a copy of the variable in its local cache.
// So if there is a change made to that variable by other thread, it won't get the updated value.
// So, when we make variable volatile, it is stored in the main memory.
class SharedObj {

    // Putting volatile solves the problem and threadReader is now able to see this value;
    private volatile boolean flag = false;

    public void setFlagTrue() {
        System.out.println("Writer thread made the flag true !!");
        flag = true;
    }

    public void printIfFlagTrue() {
        while(!flag) {
            // do nothing
        }
        System.out.println("Flag is true !!");
    }
}

public class VolatileExample {
    public static void main(String[] args) {
        SharedObj sharedObj = new SharedObj();

        Thread threadWriter = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedObj.setFlagTrue();
        });
        Thread threadReader = new Thread(() -> sharedObj.printIfFlagTrue());

        threadWriter.start();
        threadReader.start();

    }
}
