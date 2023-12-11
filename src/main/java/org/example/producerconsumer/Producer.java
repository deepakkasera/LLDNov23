package org.example.producerconsumer;

import java.util.Queue;

public class Producer implements Runnable {
    private Queue<Object> queue;
    private String name;
    private int maxSize;

    Producer(Queue<Object> queue, int maxSize, String name) {
        this.queue = queue;
        this.name = name;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            if (queue.size() < maxSize) {
                System.out.println(name + "is producing an element & size is " + queue.size());
                queue.add(new Object());
            }
        }
    }
}
