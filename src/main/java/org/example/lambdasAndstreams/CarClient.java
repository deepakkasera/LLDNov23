package org.example.lambdasAndstreams;

import java.util.*;

public class CarClient {
    public static void main(String[] args) {
        Car car1 = new Car("A", 1000, 80);
        Car car2 = new Car("C", 100, 200);
        Car car3 = new Car("Y", 500, 50);
        Car car4 = new Car("D", 600, 45);
        Car car5 = new Car("D", 200, 78);
        Car car6 = new Car("B", 150, 90);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);

        System.out.println(car1);

//        System.out.println(cars);

//        Collections.sort(cars); -> We need to define a way to compare Cars.

//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(10);
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(100);
//
//        Collections.sort(numbers);
//        System.out.println(numbers);

        //Sort the list of cars in the ascending order of their prices.
        Comparator<Car> comparator = new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                //if it returns -ve,  car1 < car2.
                //if ZERO => car1 == car2
                //if +ve => car1 > car2
                return c1.price - c2.price;
            }
        };
//        Collections.sort(cars, comparator);
//        System.out.println(cars);

        //Lambda Expression
        //(c1, c2) -> {return c1.price - c2.price;}

        Collections.sort(cars, (c1, c2) -> c1.power - c2.power);
        System.out.println(cars);
    }
}
