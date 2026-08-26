package multithreading.reentrantlock.example2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) {
        Resource r1 = new Resource();

        Thread t1 = new Thread(() -> r1.f1());
        Thread t2 = new Thread(() -> r1.f1());
        Thread t3 = new Thread(() -> r1.f1());
        Thread t4 = new Thread(() -> r1.f1());
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

class Resource {
    Lock lock = new ReentrantLock();

    void f1() {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " entered");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}

            System.out.println(Thread.currentThread().getName() + " exited");
        } finally {
            lock.unlock();
        }
    }
}
