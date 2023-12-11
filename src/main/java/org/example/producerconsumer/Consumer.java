package org.example.producerconsumer;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Object> queue;
    private String name;
    private int maxSize;

    Consumer(Queue<Object> queue, int maxSize, String name) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (queue.size() > 0){
                System.out.println(name + "is consuming an element & size is " + queue.size());
                queue.remove();
            }
        }
    }
}
