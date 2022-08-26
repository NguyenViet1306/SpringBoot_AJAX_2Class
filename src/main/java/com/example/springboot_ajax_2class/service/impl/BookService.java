package com.example.springboot_ajax_2class.service.impl;

import com.example.springboot_ajax_2class.model.Book;
import com.example.springboot_ajax_2class.repository.BookRepository;
import com.example.springboot_ajax_2class.service.IServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService implements IServiceBook {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
