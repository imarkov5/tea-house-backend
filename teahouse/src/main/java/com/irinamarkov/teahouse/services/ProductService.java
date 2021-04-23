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

    public Product updateProduct(Long id, Product productInfo) {
        Product existingProduct = this.productRepo.findById(id).orElse(null);
        existingProduct.setName(productInfo.getName());
        existingProduct.setPrice(productInfo.getPrice());
        existingProduct.setDescription(productInfo.getDescription());
        existingProduct.setImageUrl(productInfo.getImageUrl());
        existingProduct.setQuantity(productInfo.getQuantity());
        existingProduct.setCategory_id(productInfo.getCategory_id());
        existingProduct.setSerialNumber(productInfo.getSerialNumber());

        return this.productRepo.save(existingProduct);
    }

    public void deleteProduct(Long id){
//        Product deletedProduct = productRepo.findById(id).orElse(null);
        this.productRepo.deleteById(id);
    }


    public Product getProductByName(String name){
        return this.productRepo.findByName(name);
    }
    public Product getProductBySerialNumber(String serialNumber){
        return this.productRepo.findBySerialNumber(serialNumber);
    }

}
