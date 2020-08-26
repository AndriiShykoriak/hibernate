package ua.com.hibernate.service;

import ua.com.hibernate.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
}
