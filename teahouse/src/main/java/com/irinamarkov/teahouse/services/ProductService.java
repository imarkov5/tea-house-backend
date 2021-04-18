package com.irinamarkov.teahouse.services;

import com.irinamarkov.teahouse.entities.Product;
import com.irinamarkov.teahouse.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepo;

    public List<Product> getAllProducts(){
        return this.productRepo.findAll();
    }
    public Product createProduct(Product newProduct){
        return this.productRepo.save(newProduct);
    }
    public Product getOneProduct(Long id){
        return this.productRepo.findById(id).orElse(null);
    }
    public Product updateProduct(Product updatedProduct){
        return this.productRepo.save(updatedProduct);
    }
    public void deleteProduct(Long id){
        this.productRepo.deleteById(id);
    }

}
