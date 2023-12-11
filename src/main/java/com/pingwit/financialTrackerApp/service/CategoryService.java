package com.pingwit.financialTrackerApp.service;

import com.pingwit.financialTrackerApp.entity.Category;
import com.pingwit.financialTrackerApp.exception.CategoryExistsException;
import com.pingwit.financialTrackerApp.exception.CategoryNotFoundException;
import com.pingwit.financialTrackerApp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;

    public List<String> getOnlyCategories() {
        return categoryRepository.getOnlyCategories();
    }

    public List<Category> getCategory() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll()
                .forEach(categories::add);
        return categories;
    }

    public void addCategory(Category category) throws CategoryExistsException {
        categoryRepository.save(category);
    }

    public Long getIdForCategory(String category) throws CategoryNotFoundException {
        return categoryRepository.getIdForCategory(category);
    }

    public void deleteCategoryByName(String category) throws CategoryNotFoundException {
        Optional<Category> deleteCategory = categoryRepository.findCategoryByName(category);
        if (deleteCategory.isPresent()) {
            categoryRepository.delete(deleteCategory.get());
        } else {
            throw new CategoryNotFoundException("Category does not exist: " + category);
        }
    }

    public Category findCategoryByName(String category) throws CategoryNotFoundException {
        Optional<Category> findCategoryByName = categoryRepository.findCategoryByName(category);
        if (findCategoryByName.isPresent()) {
            return findCategoryByName.get();
        } else {
            throw new CategoryNotFoundException("Expense does not exist: " + category);
        }
    }
}
