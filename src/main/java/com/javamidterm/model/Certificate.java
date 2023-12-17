package com.javamidterm.model;

public class Certificate {

    private int certificateId;
    private int studentId;
    private String certificateName;

    public Certificate() {
    }

    public Certificate(int studentId, String certificateName) {
        this.studentId = studentId;
        this.certificateName = certificateName;
    }

    public Certificate(int certificateId, int studentId, String certificateName) {
        this.certificateId = certificateId;
        this.studentId = studentId;
        this.certificateName = certificateName;
    }

    public int getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(int certificateId) {
        this.certificateId = certificateId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    @Override
    public String toString() {
        return "Certificate{" + "certificateId=" + certificateId + ", studentId=" + studentId + ", certificateName=" + certificateName + '}';
    }

}
