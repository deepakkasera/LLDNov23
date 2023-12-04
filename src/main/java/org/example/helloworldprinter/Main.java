package org.example.helloworldprinter;

public class Main {
    public static void main(String[] args) {
        //main thread.
        System.out.println("Hello World, Printed by: " + Thread.currentThread().getName());

        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        Thread thread = new Thread(helloWorldPrinter);
        thread.start();

        System.out.println("Hello World, Printed by: " + Thread.currentThread().getName());

        //helloWorldPrinter.run();
    }
}
