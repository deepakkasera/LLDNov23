package org.example.addersubtractoratomicinteger;

public class Subtractor implements Runnable {
    Count count;

    Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100000; i++) {
            count.value.getAndAdd(-i);
        }
    }
}
