package org.example.inheritance3;

public class Main {
    public static void main(String[] args) {
        A a = new C();

        a.age = 10;
        a.name = "Deepak";
        // a.companyName = "Scaler";

        //Note - Because compiler only knows about the left side i.e the type of variable we are creating,
        //Compiler doesn't know about what type of object we are going to store in the variable,
        //as the object creation happens at Run Time.
        System.out.println("DEBUG");
    }
}
