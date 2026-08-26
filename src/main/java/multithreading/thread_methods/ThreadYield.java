package multithreading.thread_methods;

public class ThreadYield {
    public static void main(String[] args) {

    }
}

/*

  Thread.yield() ---> ➊ I am willing to give my CPU time to someone else with same priority that wants to run.
                      ➊ OS can reject this, since its JVM that handles the scheduling of threads.
                      ➊ It is like a suggestion to the OS.
                      ➊ Current thread doesn't go to WAITING, TIMED_WAITING, BLOCKED
                      ➊ It does go to only RUNNABLE state.

 */
