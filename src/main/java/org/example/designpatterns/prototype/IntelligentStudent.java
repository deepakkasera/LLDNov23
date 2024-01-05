package org.example.designpatterns.prototype;

public class IntelligentStudent extends Student {
    private int iq;

    public IntelligentStudent() {

    }

    public IntelligentStudent(IntelligentStudent intelligentStudent) {
        super(intelligentStudent);
        this.iq = intelligentStudent.iq;
    }

    @Override
    public IntelligentStudent copy() {
//        IntelligentStudent intelligentStudent = new IntelligentStudent();
//        intelligentStudent.setName(this.getName());
//        intelligentStudent.setAge(this.getAge());
//        intelligentStudent.setBatch(this.getBatch());
//        intelligentStudent.setPsp(this.getPsp());
//        intelligentStudent.setAvgBatchPsp(this.getAvgBatchPsp());
//        intelligentStudent.setIq(this.getIq());

        IntelligentStudent intelligentStudent = new IntelligentStudent(this);
        return intelligentStudent;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
