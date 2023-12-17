
package com.javamidterm.dao;
import com.javamidterm.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public void addUser(User user) {
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO users (username, password, role, profile_picture) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setString(4, user.getProfilePicture());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void deleteUser(int userId) {
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?")) {

            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void updateUser(User user) {
        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE users SET username=?, password=?, role=?, profile_picture=? WHERE id=?")) {

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setString(4, user.getProfilePicture());
            preparedStatement.setInt(5, user.getUserId());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                user.setProfilePicture(resultSet.getString("profile_picture"));

                users.add(user);
            }

        } catch (Exception e) {
        }

        return users;
    }

    public User getUserById(int userId) {
        User user = null;

        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id=?")) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                user.setProfilePicture(resultSet.getString("profile_picture"));
            }

        } catch (Exception e) {
        }

        return user;
    }
    
    public boolean authenticateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username=? AND password=?";
        try (Connection connection = JDBCConnection.getJDBCConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (Exception e) {
            return false;
        }
    }

    public User getUserByUsername(String username) {
        User user = null;
        String query = "SELECT * FROM users WHERE username = ?";
        try (Connection connection = JDBCConnection.getJDBCConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                user.setProfilePicture(resultSet.getString("profile_picture"));
            }

        } catch (Exception e) {
            
        }
        return user;
    }
}
