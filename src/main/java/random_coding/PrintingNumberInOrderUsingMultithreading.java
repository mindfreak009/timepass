package random_coding;

public class PrintingNumberInOrderUsingMultithreading {

        private static final Object lock = new Object();
        private static int NO_OF_THREADS = 5;
        private static int PRINT_NUMBERS_UPTO = 25;
        private static int counter = 1;

        public static void main(String[] args) {
            if (args.length > 0) {
                try {
                    NO_OF_THREADS = Integer.parseInt(args[0]);
                    PRINT_NUMBERS_UPTO = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    System.err.println("Arguments must be an integer.");
                    System.exit(1);
                }
            }
            // Creating threads
            for (int i = 1; i <= NO_OF_THREADS; i++) {
                new Thread(new Generator(i % NO_OF_THREADS), "T" + i).start();
            }
        }

        static class Generator implements Runnable {

            private int remainder;
            Generator(int remainder) {
                this.remainder = remainder;
            }

            @Override
            public void run() {
                while (counter <= PRINT_NUMBERS_UPTO) {
                    synchronized (lock) {
                        while (counter % NO_OF_THREADS != remainder) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (counter % NO_OF_THREADS == remainder &&
                                counter <= PRINT_NUMBERS_UPTO) {
                            System.out.print(Thread.currentThread().getName()
                                    + "-" + counter + "\t");
                        }
                        counter++;
                        lock.notifyAll();
                    }

                }
            }

        }
}
