package com.example.springboot_ajax_2class.controller;

import com.example.springboot_ajax_2class.model.Book;
import com.example.springboot_ajax_2class.model.Category;
import com.example.springboot_ajax_2class.service.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    IServiceCategory iServiceCategory;

    @GetMapping("/{id}")
    public ResponseEntity<Category> detail(@PathVariable("id") Long id) {
        Optional<Category> optionalCategory = iServiceCategory.findById(id);
        if (optionalCategory.isPresent()) {
            return new ResponseEntity<>(optionalCategory.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Category> create(Category category) {
        return new ResponseEntity<>(iServiceCategory.save(category), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable("id") Long id) {
        Optional<Category> optionalCategory = iServiceCategory.findById(id);
        if (optionalCategory.isPresent()) {
            return new ResponseEntity<>(iServiceCategory.save(category), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") Long id) {
        iServiceCategory.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
