package org.example.producerconsumersemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Object> queue;
    private String name;
    private int maxSize;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    Consumer(Queue<Object> queue, int maxSize, String name,
             Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.name = name;
        this.maxSize = maxSize;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
//            if (queue.size() > 0){
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + "is consuming an element & size is " + queue.size());
            queue.remove();
            producerSemaphore.release();
//            }
        }
    }
}
