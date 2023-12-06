package org.example.numberPrinter1to100ExecutorService;

public class NumberPrinter implements Runnable {
    private int numberToBePrinted;

    NumberPrinter(int numberToBePrinted) {
        this.numberToBePrinted = numberToBePrinted;
    }

    @Override
    public void run() {
        System.out.println(numberToBePrinted + " Printed by thread: " + Thread.currentThread().getName());
    }
}
