package org.example.exceptions;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = "Scaler";
        String s2 = "Scaler";
        //String s3 = "scaler";
        String s4 = new String("Scaler");
        String s5 = new String("Scaler");

        System.out.println((s1 == s2) + " " + (s1.equals(s2))); // T T
        System.out.println((s1 == s4) + " " + (s1.equals(s4))); // F T
        System.out.println((s2 == s4) + " " + (s2.equals(s4))); // F T
        System.out.println((s4 == s5) + " " + (s4.equals(s5))); // F T
        System.out.println("DEBUG");
    }
}
