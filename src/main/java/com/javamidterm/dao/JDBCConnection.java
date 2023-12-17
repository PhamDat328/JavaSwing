package com.javamidterm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

    static final String URL = "jdbc:mysql://localhost:3301/StudentManagement?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false&useUnicode=yes&characterEncoding=UTF-8&allowPublicKeyRetrieval=true";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public static Connection getJDBCConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void createTables() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement();) {

            // Create users table
            String createUsersTable = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "username VARCHAR(255) UNIQUE,"
                    + "password VARCHAR(255),"
                    + "role VARCHAR(20),"
                    + "profile_picture VARCHAR(255)"
                    + ")";
            statement.executeUpdate(createUsersTable);

            // Create students table
            String createStudentsTable = "CREATE TABLE IF NOT EXISTS students ("
                    + "student_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "name VARCHAR(255),"
                    + "age INT,"
                    + "phone_number VARCHAR(15),"
                    + "status VARCHAR(20)"
                    + ")";
            statement.executeUpdate(createStudentsTable);

            // Create certificates table
            String createCertificatesTable = "CREATE TABLE IF NOT EXISTS certificates ("
                    + "certificate_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "student_id INT,"
                    + "certificate_name VARCHAR(255),"
                    + "FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE"
                    + ")";
            statement.executeUpdate(createCertificatesTable);

        } catch (Exception e) {
        }
    }

}
