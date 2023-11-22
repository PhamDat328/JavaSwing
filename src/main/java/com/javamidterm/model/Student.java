package com.javamidterm.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    // Attributes
    private int studentId; // The unique identifier for the student
    private String name;
    private int age;
    private String phoneNumber;
    private String status;
    private List<String> certificates;

    // Constructors
    
    public Student() {
    }

    public Student(String name, int age, String phoneNumber, String status, List<String> certificates) {
        this.studentId = -1; // Initialize with -1, as it will be set by the database
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.certificates = certificates;
    }

    public Student(String name, int age, String phoneNumber, String status) {
        this(name, age, phoneNumber, status, new ArrayList<>());
    }

    // Getter and Setter Methods
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

    // Additional Methods
    public void addCertificate(String certificate) {
        certificates.add(certificate);
    }

    public void removeCertificate(String certificate) {
        certificates.remove(certificate);
    }

    @Override
    public String toString() {
        return "Student{"
                + "studentId=" + studentId
                + ", name='" + name + '\''
                + ", age=" + age
                + ", phoneNumber='" + phoneNumber + '\''
                + ", status='" + status + '\''
                + ", certificates=" + certificates
                + '}';
    }
}
