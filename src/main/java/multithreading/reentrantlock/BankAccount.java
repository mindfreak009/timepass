package multithreading.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

       try{
           if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(balance >= amount){
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal ");

                        // simulate time taken to process the withdrawal
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed the  withdrawal. Remaining balance:  " + balance);
                    } catch (InterruptedException e) {
                        // clean up whatever needs to be handled before interrupted.
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance " );
                }
           } else {
               System.out.println(Thread.currentThread().getName() + " couldn't acquire the lock. Try again later !!:  ");

           }
       } catch (Exception e) {
           // clean up whatever needs to be handled before interrupted.
           Thread.currentThread().interrupt();
       }
    }


    // using the usual synchronized keyword

//    public synchronized void withdraw(int amount) {
//        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
//
//        if (balance >= amount) {
//            System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal " );
//            try {
//              Thread.sleep(10000);
//            } catch (InterruptedException e) {
//
//            }
//            balance -= amount;
//            System.out.println(Thread.currentThread().getName() + " completed withdrawal.  Remaining amount is : " + amount);
//        } else {
//            System.out.println(Thread.currentThread().getName() + " insufficient balance ");
//        }
//    }


}
