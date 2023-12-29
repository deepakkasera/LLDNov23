package org.example.designpatterns.singleton;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbc1 = DatabaseConnection.getInstance();
        DatabaseConnection dbc2 = DatabaseConnection.getInstance();



        System.out.println("DEBUG");
    }
}

// Singleton Class in multi threading environment :
//1. Early Initialization
//2. Lazy
     // 1. Synchronized keyword with getInstance() method
            // Slow performance.
     //2. Double Check Locking.


//Assignment :-
/**
 * Create a Singleton class with double check locking and check if
 * that code work by creating multiple threads in the Client class.
 */
