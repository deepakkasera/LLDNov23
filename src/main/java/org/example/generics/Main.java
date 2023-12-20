package org.example.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pair<Double, Double> pair = new Pair<>();
        pair.setFirst(3.456789);
        pair.setSecond(1.23456);

        Pair<String, String> pair1 = new Pair<>();
        pair1.setFirst("Sailesh");
        pair1.setSecond("Kumar");

        //RAW TYPES
        Pair pair2 = new Pair();
        pair2.setFirst("Scaler");
        pair2.setSecond(3.45678);
        //String value = (String) pair2.getSecond();

        // Pair<int, int> pair3 = new Pair<int, int>(); NOT POSSIBLE.

        List<Integer> list = new ArrayList<>();
        List<Double> list1 = new ArrayList<>();
        List<Pair<Double, Double>> pairs = new ArrayList<>();
        List<Boolean> booleans = new ArrayList<>();

        //Before Java 5
        //Key - Object
        //Value - Object
        HashMap hashMap = new HashMap();
        hashMap.put(10, 20);
        hashMap.put("Scaler", "Bangalore");

        //After Java 5, Generics were introduced.
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();

        //Why Raw Types are still supported by Java even if they can
        //cause RTE at some point.
        //To support the codes written before Java 5 version.
        //Backward Compatibility.


        //static method - Class level method.
        // A method that can be called without an object of the class.
        // Pair.doSomething();
        Pair.doSomething("Scaler");
        Pair.doSomething(10);
        Pair.doSomething(new Pair<Double, Double>());
        //String str = (String) Pair.doSomething2(10, "Scaler"));
        //String string  = Pair.doSomething2("Scaler", 10);
//        String s = Pair.doSomething3("Scaler", 10);
    }
}
