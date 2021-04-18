package com.irinamarkov.teahouse.controllers;

import com.irinamarkov.teahouse.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/products")
public class ProductController {
    @Autowired
    ProductService productService;

}
