package org.example.numberprinter1to100;

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
