package mrzj.demo.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestZLock {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(2);

        Counter counter = new Counter();

        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
            latch.countDown();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.decrement();
            }
            latch.countDown();
        }).start();

        latch.await();
        System.out.println(counter.get());
    }
}

class Counter {
    private int count = 0;
//    private Lock lock = new ZLock();
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();

        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();

        try {
            count--;
        } finally {
            lock.unlock();
        }
    }

    public int get() {
        return count;
    }

}