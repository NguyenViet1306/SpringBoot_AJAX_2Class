package com.example.springboot_ajax_2class.service.impl;

import com.example.springboot_ajax_2class.model.Category;
import com.example.springboot_ajax_2class.repository.CategoryRepository;
import com.example.springboot_ajax_2class.service.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService implements IServiceCategory {
@Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
