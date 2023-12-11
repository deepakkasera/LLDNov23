package org.example.producerconsumermutex;

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

    //Queue is a shared object, i.e it is being used by multiple threads at the same time.
    //So it is a Critical Section.
    //It should be used with in LOCK.

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (queue.size() < maxSize) {
                    System.out.println(name + " is producing an element & size is " + queue.size());
                    queue.add(new Object());
                }
            }
        }
    }
}
