package ua.com.hibernate.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.hibernate.model.User;
import ua.com.hibernate.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    SessionFactory SessionFactory;

    @Transactional
    @Override
    public void addUser(User user) {
        getCurrentSession().persist(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        getCurrentSession().update(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        getCurrentSession().delete(user);
    }

    @Transactional
    @Override
    public User findById(int id) {
        return getCurrentSession().get(User.class, id);
    }

    @Transactional
    @Override
    public List<User> findAll() {
        return getCurrentSession().createQuery("SELECT u from User  u", User.class).getResultList();
    }

    private Session getCurrentSession() {
        return SessionFactory.getCurrentSession();
    }
}
