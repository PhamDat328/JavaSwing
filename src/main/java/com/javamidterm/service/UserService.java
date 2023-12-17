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
        userDAO.addUser(user);
    }

    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserById(int userId) {
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
    
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
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
