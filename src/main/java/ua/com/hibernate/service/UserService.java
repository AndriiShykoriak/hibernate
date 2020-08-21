package ua.com.hibernate.service;

import ua.com.hibernate.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User findById(int id);
    List<User> findAll();
}
