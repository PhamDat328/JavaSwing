package com.javamidterm.main;

import com.javamidterm.dao.CertificateDAO;
import com.javamidterm.dao.JDBCConnection;
import com.javamidterm.dao.StudentDAO;
import com.javamidterm.service.DataImporterExporter;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//      // Instantiate DAO instances (replace with actual implementations)
        JDBCConnection.createTables();
        StudentDAO studentDAO = new StudentDAO();
        String fileName = "src/main/resources/StudentData.csv";
//        URL resourceUrl = App.class.getResource();
//        Path filePath = Paths.get(resourceUrl.getPath());
        
         
        CertificateDAO certificateDAO = new CertificateDAO();

        // Instantiate DataImporterExporter with DAO instances
        DataImporterExporter dataImporterExporter = new DataImporterExporter(studentDAO, certificateDAO);
        
        // Example: Import students from a CSV file
        dataImporterExporter.importStudentsFromFile(fileName);

//         Example: Export students to a CSV file
//        dataImporterExporter.exportStudentsToCSV("src/main/resources/exported_students.csv");
        // Example: Import certificates from a CSV file
//        dataImporterExporter.importCertificatesFromFile("path/to/certificates.csv");
        // Example: Export certificates to a CSV file
//        dataImporterExporter.exportCertificatesToCSV("path/to/exported_certificates.csv");
    }

}
