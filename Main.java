package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread() {
            public void run() {
                System.out.println("Hello from new thread");
            }
        };
        myThread.start();
        Thread.yield();
        System.out.println("Hello from main thread");
        myThread.join();

        class Counter {
            private int count = 0;
            public synchronized void increment() { ++count; }
            public synchronized void inc() { ++count; }
            public synchronized int getCount() { return count; }
        }
        final Counter counter = new Counter();

        class CountingThread extends Thread {
            public void run() {
                for (int i=0; i<10000; i++) {
                    counter.increment();
                }
            }
        }

        class CountThread extends Thread {
            public void run() {
                for (int i=0; i<10000; i++) {
                    counter.inc();
                }
            }
        }

        CountingThread t1 = new CountingThread();
        CountThread t2 = new CountThread();

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println(counter.getCount());

        Puzzle.exec();
    }
}
