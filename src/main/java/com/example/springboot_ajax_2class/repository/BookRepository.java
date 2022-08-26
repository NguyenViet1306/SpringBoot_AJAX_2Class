package com.example.springboot_ajax_2class.repository;

import com.example.springboot_ajax_2class.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {
}
