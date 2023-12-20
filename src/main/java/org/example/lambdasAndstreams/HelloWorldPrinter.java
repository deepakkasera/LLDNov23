package org.example.lambdasAndstreams;

public class HelloWorldPrinter implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello, " + Thread.currentThread().getName());
    }
}
