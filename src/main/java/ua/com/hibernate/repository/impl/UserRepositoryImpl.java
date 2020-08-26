package ua.com.hibernate.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.hibernate.model.User;
import ua.com.hibernate.repository.UserRepository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    SessionFactory SessionFactory;

    @Override
    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(User user) {
        getCurrentSession().delete(user);
    }

    @Override
    public User findById(int id) {
        return getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return getCurrentSession().createQuery("SELECT u from User  u", User.class).getResultList();
    }

    private Session getCurrentSession() {
        return SessionFactory.getCurrentSession();
    }
}
