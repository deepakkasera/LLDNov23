package org.example.designpatterns.prototype;

public class Student implements Prototype<Student> {
    private String name;
    private int age;
    private double psp;
    private String batch;
    private double avgBatchPsp;

    public Student() {}

    public Student(Student student) {
        this.name = student.name;
        this.age = student.age;
        this.batch = student.batch;
        this.psp = student.psp;
        this.avgBatchPsp = student.avgBatchPsp;
    }

//    public String getName() {
//        return name;
//    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getAge() {
//        return age;
//    }

    public void setAge(int age) {
        this.age = age;
    }

//    public double getPsp() {
//        return psp;
//    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

//    public String getBatch() {
//        return batch;
//    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

//    public double getAvgBatchPsp() {
//        return avgBatchPsp;
//    }

    public void setAvgBatchPsp(double avgBatchPsp) {
        this.avgBatchPsp = avgBatchPsp;
    }

    @Override
    public Student copy() {
//        Student copy = new Student();
//        copy.name = this.name;
//        copy.age = this.age;
//        copy.psp = this.psp;
//        copy.batch = this.batch;
//        copy.avgBatchPsp = this.avgBatchPsp;

        Student copy = new Student(this);
        return copy;
    }
}
