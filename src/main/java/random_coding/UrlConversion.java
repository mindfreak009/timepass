package random_coding;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UrlConversion {
    private static final int crunchifyThreads = 10;

    public static void main(String[] args) {
        int count = 1;
        for(int i=0; i<50; i++) {
            while(count <=i) {
                count++;
                System.out.println("j ::" +count);
            }
        }

            // Executors: Factory and utility methods for Executor, ExecutorService, ScheduledExecutorService, ThreadFactory, and Callable classes defined in this package.

            // ExecutorService: An Executor that provides methods to manage termination and methods that can produce a Future for tracking progress of one or more asynchronous tasks.
            // An ExecutorService can be shut down, which will cause it to reject new tasks.
            // Two different methods are provided for shutting down an ExecutorService.
            // The shutdown method will allow previously submitted tasks to execute before terminating, while the shutdownNow method prevents waiting tasks from starting and attempts to stop currently executing tasks.
            // Upon termination, an executor has no tasks actively executing, no tasks awaiting execution, and no new tasks can be submitted.
            // An unused ExecutorService should be shut down to allow reclamation of its resources.
            ExecutorService executor = Executors.newFixedThreadPool(crunchifyThreads);

            // newFixedThreadPool(): Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue.
            // At any point, at most nThreads threads will be active processing tasks. If additional tasks are submitted when all threads are active, they will wait in the queue until a thread is available.
            // If any thread terminates due to a failure during execution prior to shutdown, a new one will take its place if needed to execute subsequent tasks

            String[] crunchifyList = {
                    "https://crunchify.com",
                    "https://yahoo.com",
                    "https://www.ebay.com",
                    "https://google.com",
                    "https://www.example.co",
                    "https://paypal.com",
                    "http://bing.com/",
                    "https://techcrunch.com/",
                    "http://mashable.com/",
                    "https://crunchify.com/crunchy-sharing/",
                    "https://wordpress.com/",
                    "https://wordpress.org/",
                    "https://example.com/",
                    "https://sjsu.edu/",
                    "https://crunchify.com/",
                    "https://test.com.au/",
                    "https://www.wikipedia.org/",
                    "https://en.wikipedia.org"
            };

            for (int i = 0; i < crunchifyList.length; i++) {

                String url = crunchifyList[i];
                Runnable worker = new MyRunnable(url);

                // execute(): Executes the given command at some time in the future. The command may execute in a new thread, in a pooled thread,
                // or in the calling thread, at the discretion of the Executor implementation.
                executor.execute(worker);
            }

            // shutdown(): Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
            // Invocation has no additional effect if already shut down.
            // This method does not wait for previously submitted tasks to complete execution. Use awaitTermination to do that.
            executor.shutdown();

            // Wait until all threads are finish
            // Returns true if all tasks have completed following shut down.
            // Note that isTerminated is never true unless either shutdown or shutdownNow was called first.
            while (!executor.isTerminated()) {
                // empty body
            }
            System.out.println("\nFinished all threads");


        // Runnable: The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.
        // The class must define a method of no arguments called run.

    }

    public static class MyRunnable implements Runnable {
        private final String url;

        MyRunnable(String url) {
            this.url = url;
        }

        @Override
        public void run() {

            String result = "";
            int code = 200;
            try {
                URL siteURL = new URL(url);

                // HttpURLConnection: A URLConnection with support for HTTP-specific features. See the spec for details.

                // openConnection(): Returns a URLConnection instance that represents a connection to the remote object referred to by the URL.
                HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();

                // setRequestMethod: Set the method for the URL request, one of:
                //GET
                //POST
                //HEAD
                //OPTIONS
                //PUT
                //DELETE
                //TRACE
                connection.setRequestMethod("GET");

                // setConnectTimeout(): Sets a specified timeout value, in milliseconds, to be used when opening a communications link to the resource referenced by this URLConnection.
                // If the timeout expires before the connection can be established, a java.net
                connection.setConnectTimeout(3000);

                // connect(): Opens a communications link to the resource referenced by this URL, if such a connection has not already been established.
                connection.connect();

                // getResponseCode(): Gets the status code from an HTTP response message. For example, in the case of the following status lines:
                //       HTTP/1.0 200 OK
                //       HTTP/1.0 401 Unauthorized
                code = connection.getResponseCode();
                long start = System.currentTimeMillis();
                if (code == 200) {
                    result = "-> Green <-\t\t" + "Code: " + code;
                    ;
                } else {
                    result = "-> Yellow <-\t\t" + "Code: " + code;
                }
                long end = System.currentTimeMillis();
                System.out.println("Total execution time in seconds ::: " +(end-start)/1000.0);

            } catch (Exception e) {
                result = "-> Red <-\t\t" + "Wrong domain - Exception: " + e.getMessage();

            }
            System.out.println(url + "\t\t\t\tStatus:" + result);
        }
    }
}
