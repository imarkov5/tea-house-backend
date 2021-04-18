package com.irinamarkov.teahouse.services;

import com.irinamarkov.teahouse.entities.Category;
import com.irinamarkov.teahouse.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepo;

    public List<Category> getAllCategories(){
        return this.categoryRepo.findAll();
    }
    public Category createCategory(Category newCategory){
        return this.categoryRepo.save(newCategory);
    }
    public Category getCategoryById(Long categoryId){
        return this.categoryRepo.findById(categoryId).orElse(null);
    }
    public Category updateCategory(Category updatedCategory){
        return categoryRepo.save(updatedCategory);
    }
    public void deleteCategory(Long id){
        this.categoryRepo.deleteById(id);
    }

}
