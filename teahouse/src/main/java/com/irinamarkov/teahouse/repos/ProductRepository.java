package com.irinamarkov.teahouse.repos;

import com.irinamarkov.teahouse.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product>findAll();

    Product findByName(String name);

    Product findBySerialNumber(String serialNumber);
}
