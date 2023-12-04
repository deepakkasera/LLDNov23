package org.example.helloworldprinter;

public class HelloWorldPrinter implements Runnable {
    @Override
    public void run() {
        //The code which we want to execute in a separate thread.
        System.out.println("Hello World, Printed by: " + Thread.currentThread().getName());
    }
}
