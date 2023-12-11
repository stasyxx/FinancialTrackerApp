package com.pingwit.financialTrackerApp.api.controller;

import com.pingwit.financialTrackerApp.entity.Category;
import com.pingwit.financialTrackerApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/rest")
    public class CategoryController {

        @Autowired
        private CategoryService categoryService;

        @RequestMapping(method = RequestMethod.POST, value = "/category")
        public void addCategory(@RequestBody Category category){
            categoryService.addCategory(category);
        }

        @RequestMapping(method = RequestMethod.GET, value ="/category")
        public List<Category> getCategory(){
            return categoryService.getCategory();
        }

        @RequestMapping(method = RequestMethod.GET, value ="/CategoryList")
        public List<String> getCategories(){
            return categoryService.getOnlyCategories();
        }
    }

