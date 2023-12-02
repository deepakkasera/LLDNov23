package org.example.methodoverriding;

public class Client {
    public static void main(String[] args) {
        A a = new B();
        a.hello();
    }
}
