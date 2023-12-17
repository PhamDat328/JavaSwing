package com.javamidterm.dao;

import com.javamidterm.model.Certificate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CertificateDAO {

    public void addCertificate(Certificate certificate) {
        try (Connection connection = JDBCConnection.getJDBCConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO certificates (student_id, certificate_name) VALUES (?, ?)")) {

            preparedStatement.setInt(1, certificate.getStudentId());
            preparedStatement.setString(2, certificate.getCertificateName());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void deleteCertificate(int certificateId) {
        try (Connection connection = JDBCConnection.getJDBCConnection(); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM certificates WHERE certificate_id=?")) {

            preparedStatement.setInt(1, certificateId);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void updateCertificate(Certificate certificate) {
        try (Connection connection = JDBCConnection.getJDBCConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE certificates SET student_id=?, certificate_name=? WHERE certificate_id=?")) {

            preparedStatement.setInt(1, certificate.getStudentId());
            preparedStatement.setString(2, certificate.getCertificateName());
            preparedStatement.setInt(3, certificate.getCertificateId());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
        }
    }

    public List<Certificate> getCertificatesForStudent(int studentId) {
        List<Certificate> certificates = new ArrayList<>();

        try (Connection connection = JDBCConnection.getJDBCConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM certificates WHERE student_id=?")) {

            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Certificate certificate = new Certificate();
                certificate.setCertificateId(resultSet.getInt("certificate_id"));
                certificate.setStudentId(resultSet.getInt("student_id"));
                certificate.setCertificateName(resultSet.getString("certificate_name"));

                certificates.add(certificate);
            }

        } catch (Exception e) {
        }

        return certificates;
    }
    
    public List<Certificate> getAllCertificates() {
        List<Certificate> certificates = new ArrayList<>();

        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM certificates")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Certificate certificate = new Certificate();
                certificate.setCertificateId(resultSet.getInt("certificate_id"));
                certificate.setStudentId(resultSet.getInt("student_id"));
                certificate.setCertificateName(resultSet.getString("certificate_name"));

                certificates.add(certificate);
            }

        } catch (Exception e) {
        }

        return certificates;
    }

    
}
