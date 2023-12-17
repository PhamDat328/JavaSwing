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

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection connection = JDBCConnection.getJDBCConnection(); Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setPhoneNumber(resultSet.getString("phone_number"));
                student.setStatus(resultSet.getString("status"));

                students.add(student);
            }

        } catch (SQLException e) {
        }

        return students;
    }

    public void addStudent(Student student) {
        try (Connection connection = JDBCConnection.getJDBCConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO students (name, age, phone_number, status) VALUES (?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getPhoneNumber());
            preparedStatement.setString(4, student.getStatus());

            preparedStatement.executeUpdate();

            // Get the auto-generated student ID
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                student.setStudentId(generatedKeys.getInt(1));
            }

        } catch (SQLException e) {
        }
    }

    public void deleteStudent(int studentId) {
        try (Connection connection = JDBCConnection.getJDBCConnection(); PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students WHERE student_id=?")) {

            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void updateStudent(Student student) {
        try (Connection connection = JDBCConnection.getJDBCConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE students SET name=?, age=?, phone_number=?, status=? WHERE student_id=?")) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getPhoneNumber());
            preparedStatement.setString(4, student.getStatus());
            preparedStatement.setInt(5, student.getStudentId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public Student getStudentById(int id) {
        Student student = null;
        try (Connection connection = JDBCConnection.getJDBCConnection();) {
            PreparedStatement ptsm = connection.prepareStatement("SELECT * FROM Students WHERE student_id = ?");

            ptsm.setInt(1, id);
            ResultSet resultSet = ptsm.executeQuery();

            if (resultSet.next()) {
                student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setPhoneNumber(resultSet.getString("phone_number"));
                student.setStatus(resultSet.getString("status"));
            }
        } catch (Exception e) {
        }

        return student;
    }
}
