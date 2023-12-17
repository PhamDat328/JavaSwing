package com.javamidterm.service;

import com.javamidterm.dao.StudentDAO;
import com.javamidterm.model.Student;
import java.sql.SQLException;
import java.util.List;

public class StudentService {
    StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }
    
    public List<Student> getAllStudent() throws SQLException, ClassNotFoundException {
        return studentDAO.getAllStudents();
    }
    
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }
    
    public void deleteStudent(int id) throws ClassNotFoundException {
        studentDAO.deleteStudent(id);
    }
    
    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }
    
    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }
}
