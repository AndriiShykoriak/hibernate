package ua.com.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hibernate.model.Book;
import ua.com.hibernate.repository.BookRepository;
import ua.com.hibernate.repository.impl.BookRepositoryImpl;

import java.util.List;


@Service
public class BookServiceImpl implements BookRepository {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
