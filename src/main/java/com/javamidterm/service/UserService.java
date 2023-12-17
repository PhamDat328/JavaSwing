package com.javamidterm.service;

import com.javamidterm.dao.UserDAO;
import com.javamidterm.model.User;
import com.javamidterm.model.UserRoles;
import java.util.List;

public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public void addUser(User user) {
        // You can add business logic/validation here before calling the DAO method
        userDAO.addUser(user);
    }

    public void deleteUser(int userId) {
        // You can add business logic/validation here before calling the DAO method
        userDAO.deleteUser(userId);
    }

    public void updateUser(User user) {
        // You can add business logic/validation here before calling the DAO method
        userDAO.updateUser(user);
    }

    public List<User> getAllUsers() {
        // You can add business logic here, such as filtering or sorting, before calling the DAO method
        return userDAO.getAllUsers();
    }

    public User getUserById(int userId) {
        // You can add business logic here, such as additional checks, before calling the DAO method
        return userDAO.getUserById(userId);
    }

    public boolean userAuthentication(String username, String password) {
        return userDAO.authenticateUser(username, password);
    }

    public String getUserRole(String username) {
        User user = userDAO.getUserByUsername(username);

        if (user != null) {
            return user.getRole();
        }

        return null;
    }

    public boolean hasAdminRole(String username) {
        String userRole = getUserRole(username);
        return userRole != null && userRole.equals(UserRoles.ADMIN);
    }

    public boolean hasManagerRole(String username) {
        String userRole = getUserRole(username);
        return userRole != null && (userRole.equals(UserRoles.ADMIN) || userRole.equals(UserRoles.MANAGER));
    }
}
