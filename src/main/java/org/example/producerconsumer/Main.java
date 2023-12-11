package org.example.producerconsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        Queue<Object> queue = new ConcurrentLinkedQueue<>();
        int maxSize = 6;

        Producer p1 = new Producer(queue, maxSize, "P1");
        Thread t1 = new Thread(p1);
        t1.start();

        Producer p2 = new Producer(queue, maxSize, "P2");
        Thread t2 = new Thread(p2);
        t2.start();

        Producer p3 = new Producer(queue, maxSize, "P3");
        Thread t3 = new Thread(p3);
        t3.start();

        Producer p4 = new Producer(queue, maxSize, "P4");
        Thread t4 = new Thread(p4);
        t4.start();

        Producer p5 = new Producer(queue, maxSize, "P5");
        Thread t5 = new Thread(p5);
        t5.start();

        Producer p6 = new Producer(queue, maxSize, "P6");
        Thread t6 = new Thread(p6);
        t6.start();

        Consumer c1 = new Consumer(queue, maxSize, "C1");
        Thread t7 = new Thread(c1);
        t7.start();

        Consumer c2 = new Consumer(queue, maxSize, "C2");
        Thread t8 = new Thread(c2);
        t8.start();

        Consumer c3 = new Consumer(queue, maxSize, "C3");
        Thread t9 = new Thread(c3);
        t9.start();

        Consumer c4 = new Consumer(queue, maxSize, "C4");
        Thread t10 = new Thread(c4);
        t10.start();
    }
}
