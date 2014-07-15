package com.company;

import java.util.Random;

/**
 * Created by ryan on 7/14/14.
 */
public class Philosopher extends Thread {
    public static class Chopstick {}

    private String name;
    private Chopstick left, right;
    private Random random;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        this.name = name;
        this.left = left;
        this.right = right;
        random = new Random();
    }

    public void run() {
        try {
            while(true) {
                Thread.sleep(random.nextInt(1000));
                synchronized (left) {
                    synchronized (right) {
                        Thread.sleep(random.nextInt(1000));
                        System.out.println(name + " is eating");
                    }
                }
            }
        } catch(InterruptedException e) {}
    }

}
