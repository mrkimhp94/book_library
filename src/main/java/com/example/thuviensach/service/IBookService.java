package com.example.thuviensach.service;

import com.example.thuviensach.model.Book;

import java.util.Optional;

public interface IBookService {
    Iterable<Book> findAll();

    Optional<Book> findById(Long id);

    Book save(Book book);

    void delete(Long id);
}
