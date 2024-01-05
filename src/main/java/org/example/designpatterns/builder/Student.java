package org.example.designpatterns.builder;

import org.example.inheritance3.B;

import javax.naming.spi.DirObjectFactory;

public class Student {
    String name;
    int age;
    String univName;
    int gradYear;
    double psp;
    String batch;
    String companyName;

    private Student(Builder builder) {
        //validations start
//        if (builder.getGradYear() > 2022) {
//            throw new IllegalArgumentException("Grad Year can't be greater than 2022");
//        }
        //validations end
        this.name = builder.name;
        this.age = builder.age;
        this.batch = builder.batch;
        this.univName = builder.univName;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getAge() {
        return age;
    }

//    public void setAge(int age) {
//        this.age = age;
//    }

    public String getUnivName() {
        return univName;
    }

//    public void setUnivName(String univName) {
//        this.univName = univName;
//    }

    public int getGradYear() {
        return gradYear;
    }

//    public void setGradYear(int gradYear) {
//        this.gradYear = gradYear;
//    }

    public double getPsp() {
        return psp;
    }

//    public void setPsp(double psp) {
//        this.psp = psp;
//    }

    public String getBatch() {
        return batch;
    }

//    public void setBatch(String batch) {
//        this.batch = batch;
//    }

    public String getCompanyName() {
        return companyName;
    }

//    public void setCompanyName(String companyName) {
//        this.companyName = companyName;
//    }

    static class Builder { // Inner Class
        String name;
        int age;
        String univName;
        int gradYear;
        double psp;
        String batch;
        String companyName;

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getUnivName() {
            return univName;
        }

        public Builder setUnivName(String univName) {
            this.univName = univName;
            return this;
        }

        public int getGradYear() {
            return gradYear;
        }

        public Builder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public String getBatch() {
            return batch;
        }

        public Builder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public String getCompanyName() {
            return companyName;
        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        private boolean validate() {
            return true;
        }

        public Student build() {
            //Validations can come here as well.
            if (this.getGradYear() > 2022) {
                throw new IllegalArgumentException("Grad Year can't be greater than 2022");
            }
            return new Student(this);
        }
    }
}

//A { B }