package com.pingwit.financialTrackerApp.service;

import com.pingwit.financialTrackerApp.entity.Category;
import com.pingwit.financialTrackerApp.exception.CategoryNotFoundException;
import com.pingwit.financialTrackerApp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public List<String> getOnlyCategories() {
        return categoryRepository.getOnlyCategories();
    }

    public List<Category> getCategory() {
        List<Category> categories = new ArrayList<Category>();
        categoryRepository.findAll()
                .forEach(categories::add);
        return categories;
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public Long getIdForCategory(String category) {
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

    public Map<String, Long> getPieChartData() {

        List<Object[]> object = categoryRepository.getPieChartData();
        Map<String, Long> pieChart = new HashMap<String, Long>();

        for (int i = 0; i < object.size(); i++) {
            Object[] pieChartLine = object.get(i);
            String category = (String) pieChartLine[0];
            Long amount = (Long) pieChartLine[1];
            pieChart.put(category, amount);
        }
        return pieChart;
    }

    public Map<String, Long> getPieChartDataByDate(Date fDate, Date tDate) {

        List<Object[]> object = categoryRepository.getPieChartDataByDate(fDate, tDate);
        Map<String, Long> pieChart = new HashMap<String, Long>();

        for (int i = 0; i < object.size(); i++) {
            Object[] pieChartLine = object.get(i);
            String category = (String) pieChartLine[0];
            Long amount = (Long) pieChartLine[1];
            pieChart.put(category, amount);
        }
        return pieChart;
    }
}
