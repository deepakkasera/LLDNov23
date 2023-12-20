package org.example.lambdasAndstreams;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s");
            }
        };
        consumer.accept("Scaler");

    }
}
