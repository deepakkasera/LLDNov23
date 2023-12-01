package org.example.constructorchaining;

public class C extends B {
    C() {
        System.out.println("C's constructor");
    }

    C(String str) {
        System.out.println("C's constructor with param");
    }
}
