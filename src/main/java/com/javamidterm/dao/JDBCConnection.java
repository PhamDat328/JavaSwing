package com.javamidterm.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

    static final String url = "jdbc:mysql://localhost:3301/StudentManagement?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false&useUnicode=yes&characterEncoding=UTF-8&allowPublicKeyRetrieval=true";
    static final String username = "root";
    static final String password = "";

    public static Connection getJDBCConnection() throws SQLException, ClassNotFoundException {

//        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    public static boolean checkIfTableExists(final String tableName) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            // Check if a table with tableName name already exists
            DatabaseMetaData dbmData = connection.getMetaData();
            ResultSet resultSet = dbmData.getTables(null, null, tableName, null);
            while (resultSet.next()) {
                if (resultSet.getString(3).equals(tableName)) {
                    return true;
                }
            }

            connection.close();
            resultSet.close();

            return false;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
    }

    public static boolean createTable() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stm = connection.createStatement();

            if (!checkIfTableExists("student")) {
                stm.executeUpdate("create table Student (student_id INTEGER not NULL AUTO_INCREMENT, "
                        + "name varchar(50), " + "age INTEGER, " + "phoneNumber VARCHAR(20), "
                        + "status VARCHAR(10), " + "PRIMARY KEY (student_id))");
            }
            if (!checkIfTableExists("certificate")) {
                stm.executeUpdate("create table Certificate (certificate_id INT AUTO_INCREMENT NOT NULL, "
                        + "student_id INT, " + "certificate_name VARCHAR(255), "
                        + "PRIMARY KEY (certificate_id), "
                        + "FOREIGN KEY (student_id) REFERENCES Student(student_id))");
            }
            connection.close();
            stm.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
