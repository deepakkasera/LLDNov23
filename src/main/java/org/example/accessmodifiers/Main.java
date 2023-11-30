package org.example.accessmodifiers;

public class Main {
    public static void main(String[] args) {
       // Student student = new Student(); // default
//        student.name = "Deepak";
//        student.age = 27;
//        // student.batchId = 10; -> ERROR : private field.
//        student.psp = 90.0;

        // Student student1 = new Student();


        Student student = new Student("Raj", 10, 90.0, 25);
        Student student1 = new Student("Sahil", 20, 94.0, 22);

        Student studentCopy = new Student(student); // copy constructor.

        Student student2 = student1; // Not even a copy.

        System.out.println("DEBUG");
    }
}
