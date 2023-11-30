package org.example.accessmodifiers;

public class Student {
    public String name;
    private int batchId;
    protected double psp;
    int age; //default

    void changeBatchId(int newBatchId) {
        name = "Deepak";
        batchId = newBatchId;
        psp = 90.0;
        age = 27;
    }

    public Student(String studentName, int studentBatchId, double studentPsp, int studentAge) {
        name = studentName;
        batchId = studentBatchId;
        psp = studentPsp;
        age = studentAge;
    }

    public Student(Student student) { //Copy Constructor.
        name = student.name;
        age = student.age;
        batchId = student.batchId;
        psp = student.psp;
    }
}
