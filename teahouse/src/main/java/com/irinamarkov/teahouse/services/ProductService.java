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

    public Product getProductById(Long id){
        return this.productRepo.findById(id).orElse(null);
    }

    public Product updateProduct(Product productInfo) {
        Product existingProduct = this.productRepo.findById(productInfo.getId()).orElse(null);
        existingProduct.setName(productInfo.getName());
        existingProduct.setPrice(productInfo.getPrice());
        existingProduct.setDescription(productInfo.getDescription());
        existingProduct.setImageUrl(productInfo.getImageUrl());
        existingProduct.setQuantity(productInfo.getQuantity());
        existingProduct.setSerialNumber(productInfo.getSerialNumber());

        return this.productRepo.save(existingProduct);
    }

    public void deleteProduct(Long id){
        this.productRepo.deleteById(id);
    }


    public Product getProductByName(String name){
        return this.productRepo.findByName(name);
    }

}
