package org.example.exceptions;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        System.out.println(a);

//        try {
//            readFile("abc.txt");
//        } catch (IOException exception) {
//            System.out.println(exception.getMessage());
//        }


        try {
            Pair pair = new Pair("Scaler", "Bangalore");
            System.out.println(pair.first + " " + pair.second);
            return;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally block");
        }

        System.out.println("Hello");
    }

    private static void readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        fileReader.read();
    }
}
