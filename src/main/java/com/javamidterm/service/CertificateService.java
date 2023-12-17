package com.javamidterm.service;

import com.javamidterm.dao.CertificateDAO;
import com.javamidterm.model.Certificate;

import java.util.List;

public class CertificateService {
    private final CertificateDAO certificateDAO;

    public CertificateService(CertificateDAO certificateDAO) {
        this.certificateDAO = certificateDAO;
    }

    public void addCertificate(Certificate certificate) {
        // You can add business logic/validation here before calling the DAO method
        certificateDAO.addCertificate(certificate);
    }

    public void deleteCertificate(int certificateId) {
        // You can add business logic/validation here before calling the DAO method
        certificateDAO.deleteCertificate(certificateId);
    }

    public void updateCertificate(Certificate certificate) {
        // You can add business logic/validation here before calling the DAO method
        certificateDAO.updateCertificate(certificate);
    }

    public List<Certificate> getCertificatesForStudent(int studentId) {
        // You can add business logic here, such as additional checks, before calling the DAO method
        return certificateDAO.getCertificatesForStudent(studentId);
    }
}
