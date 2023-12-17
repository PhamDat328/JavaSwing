package com.javamidterm.main;

import com.javamidterm.dao.JDBCConnection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JDBCConnection.createTables();
    }
}
