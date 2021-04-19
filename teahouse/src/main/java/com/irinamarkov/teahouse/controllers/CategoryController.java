package com.irinamarkov.teahouse.controllers;

import com.irinamarkov.teahouse.entities.Category;
import com.irinamarkov.teahouse.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(){
       return this.categoryService.getAllCategories();
    }
    @PostMapping
    public Category createCategory(@RequestBody Category newCategory){
        return this.categoryService.createCategory(newCategory);
    }
}
