package com.irinamarkov.teahouse.controllers;

import com.irinamarkov.teahouse.entities.Category;
import com.irinamarkov.teahouse.entities.Product;
import com.irinamarkov.teahouse.services.CategoryService;
import com.irinamarkov.teahouse.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path="")
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }
    @PostMapping(path="")
    public Product createProduct(@RequestBody Product product){
        return this.productService.createProduct(product);
    }
    @GetMapping(path="/{id}")
    public Product getProductById(@PathVariable Long id){
        return this.productService.getOneProduct(id);
    }
    @PutMapping(path="")
    public Product updateProduct(@RequestBody Product updatedProduct){
        return this.productService.updateProduct(updatedProduct);
    }
    @DeleteMapping(path="/{id}")
    public void deleteProduct(@PathVariable Long id){
        this.productService.deleteProduct(id);
    }
    @PostMapping(path="/addCategory")
    public void addCategory(@RequestBody Category category, @RequestBody Product product){
        this.productService.updateProduct(product).setCategory(category);
    }
}
