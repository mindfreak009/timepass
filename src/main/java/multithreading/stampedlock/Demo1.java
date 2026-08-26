package multithreading.stampedlock;

import java.util.concurrent.locks.StampedLock;


// tryOptimisticRead()
//     ● Get a stamp
//     ● Read data WITHOUT locking
//     ● Checking if data is "Modififed".

//     ● if(!lock.validate(stamp)) {


class SharedResource {
    private int value = 0;
    StampedLock lock = new StampedLock();


    public int read() {
        long stamp = lock.tryOptimisticRead();
        int currentValue = value;

        try{
            Thread.sleep(1000);
        } catch (Exception e) {}

        if(!lock.validate(stamp)) {
            // fallover logic
            // try pessimistic read
            stamp = lock.readLock();
            try {
                currentValue = value;

            } finally {
                lock.unlockRead(stamp);
            }

        }
        System.out.println(Thread.currentThread().getName() + " reads values as: " +currentValue);
        return currentValue;
    }

    public void write(int newValue) {
        long stamp = lock.writeLock();
        try {
            try{
                Thread.sleep(1000);
            } catch (Exception e) {}
            value = newValue;
            System.out.println(Thread.currentThread().getName() + " changes values to: " +value);
        } finally {
            lock.unlockWrite(stamp);
        }

    }
}


public class Demo1 {
    public static void main(String[] args) {
        SharedResource sr = new SharedResource();

        Thread r1 = new Thread(() -> sr.read());
        Thread r2 = new Thread(() -> sr.read());
        Thread r3 = new Thread(() -> sr.read());

        Thread w1 = new Thread(() -> sr.write(5));
        Thread w2 = new Thread(() -> sr.write(7));
        Thread w3 = new Thread(() -> sr.write(9));

        r1.start();
        r2.start();
        r3.start();

        w1.start();
        w2.start();
        w3.start();
    }
}
