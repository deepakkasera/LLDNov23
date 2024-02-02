package org.example.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("India");
        set.add("USA");
        set.add("China");
        set.add("UAE");
        set.add("UK");

        for (String str : set) {
            System.out.println(str);
        }
        System.out.println(" just for PR practice - Chaitanya TTS Beginner Batch");
    }
}
