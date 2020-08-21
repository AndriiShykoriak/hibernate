package ua.com.hibernate.repository;

import ua.com.hibernate.model.Book;

import java.util.List;

public interface BookRepository {
    void addBook(Book book);
    List<Book> findAll();
}
