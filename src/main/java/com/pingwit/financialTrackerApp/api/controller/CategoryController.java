package com.pingwit.financialTrackerApp.api.controller;

import com.pingwit.financialTrackerApp.entity.Category;
import com.pingwit.financialTrackerApp.exception.CategoryExistsException;
import com.pingwit.financialTrackerApp.exception.CategoryNotFoundException;
import com.pingwit.financialTrackerApp.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.POST, value = "/category")
    public void addCategory(@RequestBody Category category) throws CategoryExistsException {
        categoryService.addCategory(category);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category")
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/CategoryList")
    public List<String> getCategories() {
        return categoryService.getOnlyCategories();
    }

    @GetMapping("/categoryId")
    @ApiOperation("Returns category ID by name.")
    public ResponseEntity<Long> getIdForCategory(@RequestParam String category) {
        try {
            Long categoryId = categoryService.getIdForCategory(category);
            return ResponseEntity.ok(categoryId);
        } catch (CategoryNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping("/byName")
    @ApiOperation("Returns category by name.")
    public ResponseEntity<Category> findCategoryByName(@RequestParam String name) {
        try {
            Optional<Category> categoryByName = Optional.ofNullable(categoryService.findCategoryByName(name));
            if (categoryByName.isPresent()) {
                return ResponseEntity.ok(categoryByName.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (CategoryNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @DeleteMapping(path = "{categoryName}")
    public void deleteCategoryByName(@PathVariable("categoryName") String categoryName) {
        try {
            categoryService.deleteCategoryByName(categoryName);
        } catch (CategoryNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}

