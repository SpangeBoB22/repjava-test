package task4;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 3;
        CountDownLatch latch = new CountDownLatch(numThreads);

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                // Perform some work
                System.out.println("Thread " + Thread.currentThread().getName() + " is running");
                latch.countDown();
            });
            thread.start();
        }

        // Wait for all threads to finish before continuing
        latch.await();
        System.out.println("All threads have finished");
    }
}
