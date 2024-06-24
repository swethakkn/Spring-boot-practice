package com.java.springboot.resttemplate.entity;

public class Student {
    private long studentID;
    private String studentName;
    private long collegeId;
    public Student(){}

    public Student(long studentID, String studentName, long collegeId) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.collegeId = collegeId;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }
}
