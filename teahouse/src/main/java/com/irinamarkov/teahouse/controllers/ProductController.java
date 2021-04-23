package com.irinamarkov.teahouse.controllers;
import com.irinamarkov.teahouse.entities.Product;
import com.irinamarkov.teahouse.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins= {"http://localhost:3000"})
@RequestMapping(path="/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path="")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @PostMapping(path="/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product){
        return this.productService.createProduct(product);
    }

    @GetMapping(path="/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable Long id){
        return this.productService.getProductById(id);
    }

    @PutMapping(path="/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct){
        return this.productService.updateProduct(id, updatedProduct);
    }

    @DeleteMapping(path="/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id){
        this.productService.deleteProduct(id);
    }

    @GetMapping(path="/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductByName(@PathVariable String name){
        return this.productService.getProductByName(name);
    }

    @GetMapping(path="/serial_number/{serialNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductBySerialNumber(@PathVariable String serialNumber){
        return this.productService.getProductBySerialNumber(serialNumber);
    }



}
