package com.company;

public class PhilosopherTable {
    Philosopher.Chopstick a, b, c, d, e;
    Philosopher turing, church, russell, babbage, lovelace;

    public PhilosopherTable() {
        a = new Philosopher.Chopstick();
        b = new Philosopher.Chopstick();
        c = new Philosopher.Chopstick();
        d = new Philosopher.Chopstick();
        e = new Philosopher.Chopstick();
        turing = new Philosopher("Turing", a,b);
        church = new Philosopher("Church", b,c);
        russell = new Philosopher("Russell", c,d);
        babbage = new Philosopher("Babbage", d,e);
        lovelace = new Philosopher("Lovelace", e,a);
    }

    public void run() throws InterruptedException {
        turing.start();
        church.start();
        russell.start();
        babbage.start();
        lovelace.start();
    }


}
