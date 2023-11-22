package com.javamidterm.dao;

import com.javamidterm.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> getAllStudent() throws SQLException, ClassNotFoundException {
        Connection conn = JDBCConnection.getJDBCConnection();
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Student student = new Student();

                student.setStudentId(rs.getInt("student_id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setPhoneNumber(rs.getString("phoneNumber"));
                student.setStatus(rs.getString("status"));
                student.setCertificates(getCertificatesForStudent(rs.getInt("student_id")));
                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<String> getCertificatesForStudent(int studentId) throws ClassNotFoundException {
        List<String> certificates = new ArrayList<>();

        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String selectCertificatesSQL = "SELECT certificate_name FROM Certificate WHERE student_id = ?";
            try (PreparedStatement certificateStatement = conn.prepareStatement(selectCertificatesSQL)) {
                certificateStatement.setInt(1, studentId);
                ResultSet resultSet = certificateStatement.executeQuery();
                while (resultSet.next()) {
                    certificates.add(resultSet.getString("certificate_name"));
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return certificates;
    }

    public void addStudent(Student s) throws SQLException, ClassNotFoundException {

        try {
            String sql = "INSERT INTO Student(name, age, phoneNumber, status) VALUE(?,?,?,?)";
            Connection conn = JDBCConnection.getJDBCConnection();

            PreparedStatement ptsm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ptsm.setString(1, s.getName());
            ptsm.setInt(2, s.getAge());
            ptsm.setString(3, s.getPhoneNumber());
            ptsm.setString(4, s.getStatus());

            ptsm.executeUpdate();
            ResultSet generatedKeys = ptsm.getGeneratedKeys();
            if (generatedKeys.next()) {
                s.setStudentId(generatedKeys.getInt(1));
            }

            String insertCertificatesSQL = "insert into Certificate(student_id, certificate_name) value(?, ?)";
            try {
                PreparedStatement certificateStatement = conn.prepareStatement(insertCertificatesSQL);
                for (String certificate : s.getCertificates()) {
                    certificateStatement.setInt(1, s.getStudentId());
                    certificateStatement.setString(2, certificate);
                    certificateStatement.executeUpdate();
                }
            } catch (Exception e) {
            }
            conn.close();
            ptsm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int student_id, Student s) {
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            PreparedStatement ptsm = conn.prepareStatement(
                    "update student set name = ?, age = ?, phoneNumber = ?,"
                    + " status = ? whrere student_id = ?");
            ptsm.setString(1, s.getName());
            ptsm.setInt(2, s.getAge());
            ptsm.setString(3, s.getPhoneNumber());
            ptsm.setString(4, s.getStatus());
            ptsm.setInt(5, student_id);
            ptsm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Student getStudentById(int student_id) {
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            String sql = "select * from Student where student_id = ?";
            PreparedStatement ptsm = conn.prepareStatement(sql);

            ptsm.setInt(1, student_id);
            ResultSet rs = ptsm.executeQuery();
            boolean isNext = rs.next();
            if (!isNext) {
                return null;
            }
            return new Student(rs.getString("name"), rs.getInt("age"),
                    rs.getString("phoneNumber"), rs.getString("status"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void deleteStudent(int studentId) throws ClassNotFoundException {
        try  {
            Connection conn = JDBCConnection.getJDBCConnection();
            String deleteStudentSQL = "DELETE FROM Students WHERE student_id = ?";
            try (PreparedStatement studentStatement = conn.prepareStatement(deleteStudentSQL)) {
                studentStatement.setInt(1, studentId);
                studentStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
