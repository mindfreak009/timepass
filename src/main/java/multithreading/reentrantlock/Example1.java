package multithreading.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Example1 {
    public static void main(String[] args) {
        Resource r1 = new Resource();
        Thread t1 = new Thread(() -> r1.f1());
        Thread t2 = new Thread(() -> r1.f1());
        Thread t3 = new Thread(() -> r1.f1());

        t1.start();
        t2.start();
        t3.start();
    }
}

class Resource {
    Lock lock = new ReentrantLock();

    void f1() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " started");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {}
            System.out.println(Thread.currentThread().getName() + " exited");
        } finally {
            lock.unlock();
        }
    }
}
