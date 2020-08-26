package ua.com.hibernate.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.hibernate.model.Book;
import ua.com.hibernate.repository.BookRepository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Book> findAll() {
        return getCurrentSession().createQuery("select b from Book b", Book.class).getResultList();
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
