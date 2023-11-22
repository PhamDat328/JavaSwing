package com.javamidterm.main;

import com.javamidterm.dao.JDBCConnection;
import com.javamidterm.dao.StudentDAO;
import com.javamidterm.model.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JDBCConnection db = new JDBCConnection();
        db.createTable();
        StudentDAO studentDAO = new StudentDAO();
//        List<String> cers = new ArrayList<>();
//        cers.add("oop");
//        cers.add("d&a");
//        Student s1 = new Student("Ngoc Nam", 22, "0352568244", "Active", cers); 
//        Student s2 = new Student("Phat Dat", 21, "0333678922", "Active"); 
//        studentDAO.addStudent(s1);
//        studentDAO.addStudent(s2);

//        List<Student> students = new ArrayList<>();
//        studentDAO.getAllStudent().forEach(s -> System.out.println(s));
        
        Student s = new Student("Pham Ngoc Nam", 24, "0123456789", "Active");
        studentDAO.updateStudent(1, s);
        
        Student sUpdated = studentDAO.getStudentById(1);
        System.out.println(sUpdated);
        
    }
}
