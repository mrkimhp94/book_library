package com.example.thuviensach.controller;

import com.example.thuviensach.model.Book;
import com.example.thuviensach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("books")
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping
    public ResponseEntity<Iterable<Book>> findAllBook(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Optional<Book> bookOptional = bookService.findById(id);
        return bookOptional.map(book -> new ResponseEntity<>(book, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Book> createProduct(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> bookOptional = bookService.findById(id);
        return bookOptional.map(book1 -> {
            book.setId(book1.getId());
            bookService.save(book);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Optional<Book> bookOptional = bookService.findById(id);
        return bookOptional.map(product -> {
            bookService.delete(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
