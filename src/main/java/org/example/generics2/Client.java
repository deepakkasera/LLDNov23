package org.example.generics2;

public class Client {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>();
        pair.setFirst("Sahil");
        pair.setSecond(80);
        System.out.println(pair.getFirst() + " " + pair.getSecond());

        Pair<String, Integer> p = Pair.of("Sahil", 80);

        Pair<Integer, Integer> pair1 = new Pair<>();
        pair1.setFirst(80);
        pair1.setSecond(90);

        System.out.println(findAvg(pair1));

        Pair<Double, Double> pair2 = Pair.of(10.0, 20.0);
        System.out.println(findAvg(pair2));

        Pair<String, String> pair3 = Pair.of("Scaler", "Bangalore");
        //System.out.println(findAvg(pair3));
    }

//    private static Double findPairAverage(Pair<Integer, Integer> pair) {
//        return (pair.getFirst() + pair.getSecond()) / 2.0;
//    }

    private static Double findAvg(Pair<? extends Number, ? extends Number> pair) {
        return (pair.getFirst().doubleValue() + pair.getSecond().doubleValue()) / 2;
    }

    // Can we write a method in such a way that it can find the avg
    // of all the numeric data types.
}

/*
User
Student extends User
Instructor extends User
TA extends User
Mentor extends User

? extends User

Animal
Mammal extends Animal
Aquatic extends Animal

Dog extends Mammal
Cat extends Mammal
Tiger extends Mammal

Fish extends Aquatic
Turtle extends Aquatic


Applicable for Dog and all of it's parent classes.
findNumberOfLegs(? super Dog)

? super Dog -> Represents that you can pass Dog and any parent class of Dog.

Bounds -

1. Upper Bounds -> extends
2. Lower Bound  -> super

 */