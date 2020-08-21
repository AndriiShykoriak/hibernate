package ua.com.hibernate.repository;

import ua.com.hibernate.model.User;

import java.util.List;

public interface UserRepository {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User findById(int id);
    List<User> findAll();
}
