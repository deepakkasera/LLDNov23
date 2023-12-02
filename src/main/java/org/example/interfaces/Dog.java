package org.example.interfaces;

public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public void walk() {
        System.out.println("Dog is walking");
    }

    @Override
    public void run() {
        System.out.println("Dog is running");
    }
}
