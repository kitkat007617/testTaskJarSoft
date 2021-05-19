package com.nikita.klimkin.testTaskJarSoft.service;

import com.nikita.klimkin.testTaskJarSoft.model.Category;
import com.nikita.klimkin.testTaskJarSoft.model.User;
import com.nikita.klimkin.testTaskJarSoft.repository.CategoryRepository;
import com.nikita.klimkin.testTaskJarSoft.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(Category category) {
        ValidationUtil.isNew(category);
        return categoryRepository.save(category);
    }

    public void update(Category category) {
        ValidationUtil.isUpdated(category);
        categoryRepository.save(category);
    }

    public boolean delete(int id) {
        return categoryRepository.delete(id) != 0;
    }

    public Category get(int id) {
        return categoryRepository.getOne(id);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public List<Category> getAllForUI() {
        return categoryRepository.findAllByDeleted(false);
    }
}
