package ua.com.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hibernate.model.User;
import ua.com.hibernate.repository.UserRepository;
import ua.com.hibernate.repository.impl.UserRepositoryImpl;
import ua.com.hibernate.service.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }

    @Transactional
    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Transactional
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
