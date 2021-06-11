package com.example.thuviensach.repository;

import com.example.thuviensach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
