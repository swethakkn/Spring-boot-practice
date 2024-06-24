package com.java.springboot.resttemplate.entity;

public class College {
    private long collegeId;
    private String collegeName;
    private String collegeAddress;
    public College(){

    }

    public College(long collegeId, String collegeName, String collegeAddress) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.collegeAddress = collegeAddress;
    }

    public long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeAddress() {
        return collegeAddress;
    }

    public void setCollegeAddress(String collegeAddress) {
        this.collegeAddress = collegeAddress;
    }
}
