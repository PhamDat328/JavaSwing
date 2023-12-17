package com.javamidterm.service;

import com.javamidterm.dao.CertificateDAO;
import com.javamidterm.dao.StudentDAO;
import com.javamidterm.model.Certificate;
import com.javamidterm.model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataImporterExporter {
    private final StudentDAO studentDAO;
    private final CertificateDAO certificateDAO;

    public DataImporterExporter(StudentDAO studentDAO, CertificateDAO certificateDAO) {
        this.studentDAO = studentDAO;
        this.certificateDAO = certificateDAO;
    }

    public void importStudentsFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println(data[0]);
                if (data.length == 4) { // Assuming CSV format: name, age, phone_number, status
                    Student student = new Student();
                    student.setName(data[0].trim());
                    student.setAge(Integer.parseInt(data[1].trim()));
                    student.setPhoneNumber(data[2].trim());
                    student.setStatus(data[3].trim());
                    this.studentDAO.addStudent(student);
                }
            }
        } catch (IOException | NumberFormatException e) {
        }
    }

    public void exportStudentsToCSV(String filePath) {
        List<Student> students = studentDAO.getAllStudents();

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Student student : students) {
                String line = String.format("%s,%d,%s,%s\n",
                        student.getName(), student.getAge(), student.getPhoneNumber(), student.getStatus());
                writer.write(line);
            }
        } catch (IOException e) {
        }
    }

    public void importCertificatesFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) { // Assuming CSV format: student_id, certificate_name
                    Certificate certificate = new Certificate();
                    certificate.setStudentId(Integer.parseInt(data[0].trim()));
                    certificate.setCertificateName(data[1].trim());
                    certificateDAO.addCertificate(certificate);
                }
            }
        } catch (IOException | NumberFormatException e) {
        }
    }

    public void exportCertificatesToCSV(String filePath) {
        List<Certificate> certificates = certificateDAO.getAllCertificates();

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Certificate certificate : certificates) {
                String line = String.format("%d,%s\n", certificate.getStudentId(), certificate.getCertificateName());
                writer.write(line);
            }
        } catch (IOException e) {
        }
    }
}
