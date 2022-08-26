package com.example.springboot_ajax_2class.controller;

import com.example.springboot_ajax_2class.model.Book;
import com.example.springboot_ajax_2class.service.IServiceBook;
import com.example.springboot_ajax_2class.service.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    IServiceBook iServiceBook;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return  new ResponseEntity<>(iServiceBook.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> detail(@PathVariable("id") Long id) {
        Optional<Book> bookOptional = iServiceBook.findById(id);
        if (bookOptional.isPresent()){
            return new ResponseEntity<>(bookOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return  new ResponseEntity<>(iServiceBook.save(book), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@RequestBody Book book) {
        Optional<Book> bookOptional = iServiceBook.findById(book.getId());
        if (bookOptional.isPresent()) {
            return new ResponseEntity<>(iServiceBook.save(book), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable("id") Long id) {
        iServiceBook.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
