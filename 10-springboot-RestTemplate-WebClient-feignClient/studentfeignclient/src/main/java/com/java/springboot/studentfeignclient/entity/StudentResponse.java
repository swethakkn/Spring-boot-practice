package com.java.springboot.studentfeignclient.entity;

public class StudentResponse {
    private Student student;
    private College college;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
