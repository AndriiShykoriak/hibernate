package ua.com.hibernate.service;

import ua.com.hibernate.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    List<Book> findAll();
}
