package org.example.lambdasAndstreams;

public class Car {
    String name;
    int price;
    int power;

    Car(String name, int price, int power) {
        this.name = name;
        this.price = price;
        this.power = power;
    }

    @Override
    public String toString() {
        return "[ Name:" + this.name + ", Price: " + this.price + ", Power: " + this.power + " ]\n";
    }
}
